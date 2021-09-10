package Test01.AllTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.net.URL;

public class ATest {
    public static void main(String[] args) throws Exception{
        //获取页面源码
        Document document = Jsoup.parse(new URL("https://www.gushiwen.cn/"), 10000);
        //获取各类古诗url
        Elements as = document.select("body > div.main3 > div.right > div:nth-child(2) > div.cont > a");
        int i = 1;
        for (Element a:as) {
            //解析类名
            String styleName = a.text();
            if(styleName.contains(">>")
//                    || styleName.contains("小学")
//                    || styleName.contains("初中")
//                    || styleName.contains("高中")
                    || styleName.contains("三百")//以下为已爬取
                    || styleName.contains("宋词精选")
                    || styleName.contains("古诗十九")
            ){
                System.out.println(styleName);
            } else {
                System.out.println("正在爬取" + styleName + "...");
                //所有类的url
                String url = a.attr("href");
                //逐个类别解析
                String all = new SingleTest().singleTest(url);
                //保存诗歌
                testFileWriter(all, "D:/Test/poems/" + styleName + ".txt");
                System.out.println(styleName + " 保存成功!");
            }
        }
    }
    //存储各类诗歌
    public static void testFileWriter(String text, String outPath) {
        try {
            FileWriter fw = new FileWriter(outPath);

            fw.write(text);//写到内存

            fw.flush();//刷入硬盘

            fw.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
