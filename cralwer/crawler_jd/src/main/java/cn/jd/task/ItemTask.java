package cn.jd.task;

import cn.jd.pojo.Item;
import cn.jd.service.ItemService;
import cn.jd.util.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private ItemService itemService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //当下载任务完成后，间隔多长时间进行下一次任务
    @Scheduled(fixedDelay = 100 * 1000)
    public void itemTask() throws Exception {
        //声明需要解析的初始地址
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=0ddd22e3884a4911b36902955abaf129&s=176&click=0&page=";
        //按照页码对手机搜索结果进行解析
        for (int i = 1; i < 20; i += 2) {
            String html = httpUtils.doGetHtml(url + i);
            //解析页面，获取商品数据并存储
            this.parse(html);
        }

        System.out.println("抓取完成！");
    }

    private void parse(String html) throws Exception {
        //解析html获取Document对象
        Document document = Jsoup.parse(html);
        //获取spu信息
        Elements spuEles = document.select("div#J_goodsList > ul > li");

        for (Element e: spuEles) {
            //获取spu
            long spu = Long.parseLong(e.attr("data-spu"));
            //获取sku
            Elements skuEles = e.select("li.ps-item");
            for (Element e1:skuEles) {
                Long sku = Long.parseLong(e1.select("[data-sku]").attr("data-sku"));
                //根据sku查询商品数据
                Item item = new Item();
                item.setSku(sku);
                List<Item> list = this.itemService.findAll(item);
                //如果商品存在，就进行下一次循环，不保存
                if(list.size() > 0) {
                    continue;
                }
                //设置商品spu
                item.setSpu(spu);

                //获取商品详细url
                String itemUrl = "https://item.jd.com/" + sku + ".html";
                item.setUrl(itemUrl);
                //获取商品图片
                String picUrl = "https:" + e1.select("img[data-sku]").attr("data-lazy-img");
                picUrl = picUrl.replace("/n7/", "/n1/");
                String picName = this.httpUtils.doGetImage(picUrl);
                item.setPic(picName);
                //获取商品价格
                String priceJson = this.httpUtils.doGetHtml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
                double price = MAPPER.readTree(priceJson).get(0).get("p").asDouble();
                item.setPrice(price);
                //获取商品标题
                String itemInfo = this.httpUtils.doGetHtml(itemUrl);
                Document itemDoc = Jsoup.parse(itemInfo);
                String title = itemDoc.select("div.sku-name").text();
                item.setTitle(title);
                //设置商品创建时间
                item.setCreated(new Date());
                //设置商品更新时间
                item.setUpdated(item.getCreated());
                //保存商品数据到数据库中
                this.itemService.save(item);
            }
        }
    }
}
