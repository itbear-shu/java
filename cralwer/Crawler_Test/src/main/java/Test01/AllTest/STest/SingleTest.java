package Test01.AllTest.STest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class SingleTest {
    public String singleTest(String url) throws Exception {
        Document document = Jsoup.parse(new URL(url), 10000);
        //获取typecont信息
        Elements typeconts = document.getElementsByClass("typecont");

        String all = "";
        for (Element typecont : typeconts) {
            //获取spans
            Elements spans = typecont.getElementsByTag("span");
            //便利spans
            for (Element span : spans) {
                String p_url = "https://so.gushiwen.cn/" + span.select("a").attr("href");
                String p_name = span.getElementsByTag("a").text();
                all += p_name + "*";
                all = doUrl(p_url, all);
                all += p_url + "\n";
            }
        }
        return all;
    }

    public static String doUrl(String url, String all) throws Exception {
        Document document = Jsoup.parse(new URL(url), 10000);

        String name = document.select("#sonsyuanwen > div.cont > p > a:nth-child(1)").text();
        all += name + "*";

        String dynasty = document.select("#sonsyuanwen > div.cont > p > a:nth-child(2)").text().replace("〔", "")
                .replace("〕", "");
        all += dynasty + "*";

        try {
            String content = document.select("div.contson").first().text();
            all += content + "*";
        } catch (Exception e) {
        }
//        String mix = "";
//        Elements ps = document.select("div.contyishang > p");
//        for (Element p : ps) {
//            mix += p.text();
//        }
//        all += mix + "*";
        return all;
    }
}