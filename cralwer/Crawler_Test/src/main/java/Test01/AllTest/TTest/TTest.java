package Test01.AllTest.TTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class TTest {
    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(new URL("https://so.gushiwen.cn/gushi/xiaoxue.aspx"), 10000);
        //获取typecont信息
        Elements typeconts = document.getElementsByClass("typecont");

        int i = 1;
        for (Element typecont : typeconts) {
            //获取spans
            Elements spans = typecont.getElementsByTag("span");
            //便利spans
            for (Element span : spans) {
                String p_url = span.select("a").attr("href");
                String p_name = span.getElementsByTag("a").text();
                System.out.println(i + "、" + p_name);
//                doUrl(p_url);
                System.out.println("详情页url: " + p_url);
                i++;
            }
            System.out.println("========================================================");
        }
    }

    public static void doUrl(String url) throws Exception{
        Document document = Jsoup.parse(new URL(url), 10000);

        String name = document.select("#sonsyuanwen > div.cont > p > a:nth-child(1)").text();
        System.out.println("作者: " + name);

        String dynasty = document.select("#sonsyuanwen > div.cont > p > a:nth-child(2)").text().replace("〔", "")
                .replace("〕", "");
        System.out.println("朝代: " + dynasty);

        String content = document.select("div.contson").first().text();
        System.out.println("诗歌原文: " + content);

        String mix = "";
        Elements ps = document.select("div.contyishang > p");
        for (Element p : ps) {
            mix += p.text();
        }

        System.out.println("mix: " + mix);
//        String translation = "";
//        String annotation = "";
//        try {
//            translation = mix.split("注释")[0].replace("译文 ", "译文: ");
//            System.out.println(translation);
//        } catch (Exception e) {
//            System.out.println("译文: []");
//        }
//
//        try {
//            annotation = mix.split("注释")[1];
//            System.out.println("注释和赏析: " + annotation);
//        } catch (Exception e) {
//            System.out.println("注释和赏析: []");
//        }

    }
}
//"div.contyishang > div:nth-child(2) > h2"