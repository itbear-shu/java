# Jsoup

```java
package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Set;

public class JsoupFirstTest {

    @Test//Jsoup解析url
    public void testUrl() throws Exception {
        //解析url地址，第一个参数是访问的url，第二个参数是访问的超时时间
        Document doc = Jsoup.parse(new URL("https://www.itcast.cn"), 10000);

        //使用标签选择器,获取title标签中的内容
        String text = doc.getElementsByTag("title").text();

        //打印
        System.out.println(text);
    }

    @Test//Jsoup解析字符串
    public void testString() throws Exception {
        //使用工具栏读取文件，获取字符串
        String content = FileUtils.readFileToString(new File("C:\\Users\\雄哥\\OneDrive\\桌面\\test.html"), "utf-8");

        //解析字符串
        Document doc = Jsoup.parse(content);

        Elements tag = doc.getElementsByTag("title");
        System.out.println(tag.first().text());
    }

    @Test//Jsoup解析文件
    public void testFile() throws Exception {
        //解析文件
        Document doc = Jsoup.parse(new File("C:\\Users\\雄哥\\OneDrive\\桌面\\test.html"), "utf-8");

        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    @Test//使用Dom获取元素
    public void testDom() throws Exception {
        //解析文件，获取Document对象
        Document doc = Jsoup.parse(new File("C:\\Users\\雄哥\\OneDrive\\桌面\\test.html"), "utf-8");

        //获取元素
        Element elementById = doc.getElementById("city_bj");
        System.out.println("通过Id获取元素：" + elementById.text());

        Elements elementsByTag = doc.getElementsByTag("span");
        System.out.println("通过Tag获取元素：" + elementsByTag.first().text());//element2.first().text()

        Elements elementsByClass = doc.getElementsByClass("class_a class_b");
        System.out.println("通过Class获取元素：" + elementsByClass.first().text());

        Elements elementsByAttribute = doc.getElementsByAttribute("abc");
        System.out.println("通过Attribute获取元素：" + elementsByAttribute.first().text());

        Elements elementsByAttributeValue = doc.getElementsByAttributeValue("href", "http://gz.itcast.cn");
        System.out.println("通过AttributeValue获取元素：" + elementsByAttributeValue.first().text());
    }

    @Test//获取元素中的数据
    public void testData() throws Exception {
        //解析文件，获取document
        Document document = Jsoup.parse(new File("C:\\Users\\雄哥\\OneDrive\\桌面\\test.html"), "utf8");

        //获取元素
        Element element = document.getElementById("test");
        /*<li id="test" class="class_a class_b">
            <a href="http://www.itcast.cn" target="_blank">
                  <span class="s_name">鍖椾含</span>
            </a>
      </li>*/

        String str = "";

        //从元素中获取数据
        //1.获取id
        str = element.id();
        //2.获取classname
        str = element.className();
        //classnames
        Set<String> strings = element.classNames();
        for (String s: strings) {
            System.out.println(s);
        }
        //3.获取属性值attr
        str = element.attr("id");
        str = element.attr("class");
        //4.获取attributes
        Attributes attributes = element.attributes();
        System.out.println(attributes.toString());
        //5.获取文本内容text
        String text = element.text();
        System.out.println(text);

        System.out.println("获取到的数据是: " + str);

    }

    @Test//使用选择器获取元素
    public void testSelector() throws Exception {
        //解析文件
        Document doc = Jsoup.parse(new File("D:/Test/test.html"), "utf-8");

        //tagname:通过标签查找，比如：span
        Elements elements = doc.select("span");
        for (Element element: elements) {
            System.out.println(element.text());
        }
        //#id:通过id的值查找，比如：#city_bj(加了#)
        Elements element_id1 = doc.select("#city_bj");
        Elements element_id2 = doc.select("#test");
        System.out.println(element_id1.text());
        System.out.println(element_id2.text());
        //.class:通过class的值查找，比如：.class_a
        Elements element_class = doc.select(".class_a");
        System.out.println(element_class.text());
        //[attribute]：通过属性名查找，比如：[abc]
        Elements element_attribute = doc.select("[abc]");
        System.out.println(element_attribute.text());
        //[atrr=value]:通过属性值查找，比如:[class=s_name]
        Elements elements1 = doc.select("[class=s_name]");
        for (Element element : elements1) {
            System.out.println(element.text());
        }
    }

    @Test//选择器组合
    public void testSelctor2() throws Exception {
        //解析文件
        Document doc = Jsoup.parse(new File("D:/Test/test.html"), "utf-8");

        //el#id；元素+id
        Elements elements1 = doc.select("li#test");
        System.out.println(elements1.text());
        //el.class；元素＋class
        Elements elements2 = doc.select("span.s_name");
        for (Element element : elements2) {
            System.out.print(element.text() + " ");
        }
        System.out.println();
        System.out.println("-------------------");
        //el[attr]:元素＋属性名
        Elements elements3 = doc.select("a[href]");
        for (Element element : elements3) {
            System.out.println(element.attr("href"));
        }
        System.out.println("-------------------");
        //可以任意组合:比如:span.s_name[abc]
        Elements elements4 = doc.select("span.s_name[abc]");
        System.out.println(elements4.text());
        System.out.println("-------------------");
        //ancestor child：查找某个元素的子元素，如(.city_con li)查找(city_con) 下所有li
        Elements elements5 = doc.select(".city_con li");
        for (Element e:elements5
             ) {
            System.out.println(e.text());
        }
        System.out.println("-------------------");
        //parent > child：查找某个父元素下的直接子元素，如：(.city_con > ul > li)
        // 查找city_con第一级（直接子元素）ul,再查找所有ul的第一级li
        Elements elements6 = doc.select(".city_con > ul > li");
        for (Element e:elements6
             ) {
            System.out.println(e.text());
        }
        System.out.println("-------------------");
        //parent > *:查找某个父元素下所有的直接子元素
        Elements elements7 = doc.select(".city_con > *");
        for (Element e:elements7
             ) {
            System.out.println(e.text());
        }
        System.out.println("-------------------");
    }
}
```