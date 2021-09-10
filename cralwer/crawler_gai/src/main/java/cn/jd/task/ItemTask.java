package cn.jd.task;

import cn.jd.pojo.Item;
import cn.jd.service.ItemService;
import cn.jd.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.sql.Date;

@Component
@Transactional
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private ItemService itemService;

    //当下载任务完成后，间隔多长时间进行下一次任务
    @Scheduled(fixedDelay = 100 * 1000)
    public void itemTask() throws Exception {
        System.out.println("正在抓取...");
        //声明需要解析的初始地址
        String url = "https://so.gushiwen.cn/gushi/tangshi.aspx";
        //按照页码对手机搜索结果进行解析
        String html = this.httpUtils.doGetHtml(url);
        //解析页面，获取商品数据并存储
        this.parse(html);
        System.out.println("抓取完成！");
    }

    private void parse(String html) throws Exception {
        //解析html获取Document对象
        Document document = Jsoup.parse(html);
        //获取typecont信息
        Elements typeconts = document.getElementsByClass("typecont");
        for (Element typecont: typeconts) {
            //获取spans
            Elements spans = typecont.getElementsByTag("span");
            //遍历spans
            int i = 1;
            for (Element span:spans) {
                Item item = new Item();
                item.setId(new Long((long)i));
                //设置诗歌详情页url
                String p_url = "https://so.gushiwen.cn/" + span.select("a").attr("href");

                //设置诗歌名
                String title = span.getElementsByTag("a").text();
                item.setTitle(title);

                doUrl(p_url, item);
                //设置创建时间
                item.setCreated(new Date(new java.util.Date().getTime()));
                //设置更新时间
                item.setUpdated(item.getCreated());
                //保存数据到数据库中
                this.itemService.save(item);
            }
        }
    }

    private void doUrl(String url, Item item) throws Exception{
        //解析诗歌详情页url
        Document document = Jsoup.parse(new URL(url), 10000);
        //设置作者姓名
        String name = document.select("#sonsyuanwen > div.cont > p > a:nth-child(1)").text();
        item.setName(name);
        //设置作者朝代
        String dynasty = document.select("#sonsyuanwen > div.cont > p > a:nth-child(2)").text().replace("〔", "")
                .replace("〕", "");
        item.setDynasty(dynasty);
        //设置诗歌原文
        String content = document.select("div.contson").first().text();
        item.setContent(content);
        //分割线.............................
    }
}

