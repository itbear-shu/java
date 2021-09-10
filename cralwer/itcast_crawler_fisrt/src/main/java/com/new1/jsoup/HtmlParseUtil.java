package com.new1.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {
    public static void main(String[] args) throws Exception {
        List<Jd_info> jd_infos = getJdinfo("手机", 2);
        for (Jd_info j:jd_infos
             ) {
            j.showInfo();
        }
    }

    public static List<Jd_info> getJdinfo(String keywords, int pages) throws Exception {
        ArrayList<Jd_info> jd_infos = new ArrayList<>();
        for(int i = 1;i <= pages*2 + 1;i +=2) {
            //url
            String url = "https://search.jd.com/Search?keyword=" + keywords + "&page=" + i;
            //Jsoup解析
            Document doc = Jsoup.parse(new URL(url), 30000);
            Element element = doc.getElementById("J_goodsList");
            //获取所有li标签
            Elements lis = element.getElementsByTag("li");
            for (Element li:lis
            ) {
                //图片：所有的图片都是延迟加载
                String imgUrl = "https://" + li.getElementsByTag("img").eq(0).attr("data-lazy-img").replace("/n7/", "/n1/");
                String price = li.getElementsByClass("p-price").eq(0).text();
                String title = li.getElementsByClass("p-name").eq(0).text();

                Jd_info jd_info = new Jd_info();
                jd_info.setPrice(price);
                jd_info.setTitle(title);
                jd_info.setImgUrl(imgUrl);
                jd_infos.add(jd_info);
            }
        }
        return jd_infos;
    }
}
