package Test01.AllTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class SingleTest {
    public String singleTest(String url) throws Exception{
        Document document = Jsoup.parse(new URL(url), 10000);
        //获取typecont信息
        Elements typeconts = document.getElementsByClass("typecont");
        
        String all = "";
        int i = 1;
        for (Element typecont : typeconts) {
            //获取spans
            Elements spans = typecont.getElementsByTag("span");
            //便利spans
            for (Element span : spans) {
                String p_url = "https://so.gushiwen.cn/" + span.select("a").attr("href");
                String p_name = span.getElementsByTag("a").text();
                all += i + "、" + p_name + "\n";
                all = doUrl(p_url, all);
                all += "详情页url: " + p_url + "\n";
                i++;
            }
            all += "The End." + "\n";
        }
        return all;
    }

    public static String doUrl(String url, String all) throws Exception{
        Document document = Jsoup.parse(new URL(url), 10000);

        String name = document.select("#sonsyuanwen > div.cont > p > a:nth-child(1)").text();
        all += "作者: " + name + "\n";

        String dynasty = document.select("#sonsyuanwen > div.cont > p > a:nth-child(2)").text().replace("〔", "")
                .replace("〕", "");
        all +="朝代: " + dynasty + "\n";

        try {
            String content = document.select("div.contson").first().text();
            all += "诗歌原文: " + content + "\n";
        } catch (Exception e) {
        }
        String mix = "";
        Elements ps = document.select("div.contyishang > p");
        for (Element p : ps) {
            mix += p.text();
        }
        all += mix;
        return all;
    }
}