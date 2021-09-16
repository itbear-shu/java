package Second.task;


import Second.pojo.Novel;
import Second.service.NovelService;
import Second.util.HttpUtils;
import Second.util.JDBCUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Component
@Transactional
public class NovelTask {
    @Autowired
    private static Long count = Long.valueOf(0);

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private NovelService novelService;

    @Autowired
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    //当下载任务完成后，间隔多长时间进行下一次任务
    @Scheduled(fixedDelay = 100 * 1000)
    public void itemTask() throws Exception {
        for (int i = 1; i <= 240; i++) {
            //声明需要解析的初始地址
            String url = "https://xs.sogou.com/0_0_1_0_heat/?pageNo=" + i;
            System.out.println("正在抓取: " + url);
            //按照页码结果进行解析
            String html = this.httpUtils.doGetHtml(url);
            //解析页面
            this.parse(html);
        }

    }

    private void parse(String html) throws Exception {
        //解析html获取Document对象
        Document document = Jsoup.parse(html);
        //获取li标签
        Elements lis = document.select("ul.filter-ret > li");
        for (Element li : lis) {
            Novel novel = new Novel();
//            novel.setId(count);
//            count++;
            //获取封面url
            String f_url = "https:" + li.select("a > img").attr("src");
            novel.setF_url(f_url);
            //获取书本所有章节页面url
            String n_url = "https://xs.sogou.com" + li.select("div > h3 > a").attr("href");
            novel.setN_url(n_url);
            doUrl(n_url, novel);
        }
    }

    private void doUrl(String url, Novel novel) throws Exception {
        String html = this.httpUtils.doGetHtml(url);
        Document doc = Jsoup.parse(html);
        String name = doc.select("h1.text-title").text();//书名
        novel.setName(name);
        String writer = doc.select("div.field > span:nth-child(1)").text().split("：")[1];//作者名
        novel.setWriter(writer);
        String type = doc.select("div.field > span:nth-child(2)").text().split("：")[1];//书的类型
        novel.setType(type);
        String state = doc.select("div.field > span:nth-child(3)").text().split("：")[1];//书的完成状态
        novel.setState(state);
        Integer word_count = Integer.valueOf(doc.select("div.field > span:nth-child(4)").text().split("：")[1].split("万")[0]);//单位：万
        novel.setWord_count(word_count);
        String source = doc.select("div.field > span:nth-child(5)").text().split("：")[1];//来源
        novel.setSource(source);
        novel.setCreate_time(new Date());
        String sql = "insert into novel_copy1 values(null, ?, ?, ?, ?, ?, ?, ?, ?, default)";
        int update = template.update(sql, name, writer, type, state, word_count, source, novel.getN_url(), novel.getF_url());
        if(update == 1) {
            System.out.println(novel);
        } else {
            System.out.println("! " + novel);
        }

    }
}

