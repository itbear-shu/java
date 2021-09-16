package First;

import First.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dourls {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private static Long novel_count;
    private static Long content_count;
    private int co = 0;

    Dourls() {

    }

    public Dourls(int co) {
        this.co = co;
    }

    public void getUrls() {
        novel_count = template.queryForObject("select max(id) from novel ", Long.class);
        content_count = template.queryForObject("select max(id) from content ", Long.class);
        final List<Map<String, Object>> list_novel = template.queryForList("select name, writer, type, state, word_count, source, n_url, f_url from novel");
//        List<Map<String, Object>> list_content = template.queryForList("select number, title, word_count, update_time, url, cont, content_id from content");
        ExecutorService es = Executors.newFixedThreadPool(100);
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for (int i = co; i <= 240; i++) {
                    System.out.println("page = " + i);
                    String url = "https://xs.sogou.com/0_0_1_0_heat/?pageNo=" + i;
                    //获取整个页面的document对象
                    Document document = null;
                    try {
                        document = Jsoup.parse(new URL(url), 100000);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //获取li标签
                    Elements ele = document.select("body > div.wrapper > div.box-center.sx-wp.clear > div.sx-ret.fr > ul > li");
                    for (Element li : ele) {
                        //获取封面url
                        String f_url = "https:" + li.select("a > img").attr("src");
                        //获取书本所有章节页面url
                        String n = li.select("div > h3 > a").attr("href");
                        String n_url = "https://xs.sogou.com" + n;
                        String id = n.split("/")[2];
                        String list_url = "https://xs.sogou.com/list/" + id;
                        Long count = null;
                        try {
                            count = doNurl(n_url, f_url, list_novel);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        doListUrl(list_url, count);
                    }
                }
            }
        };
        es.submit(run);

    }

    public boolean isContainsNC(List<Map<String, Object>> list, String s) {
        for (Map<String, Object> map : list) {
            if (map.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public Long doNurl(String n_url, String f_url, List<Map<String, Object>> list_novel) throws Exception {
        Document doc = Jsoup.parse(new URL(n_url), 100000);
        String name = doc.select("h1.text-title").text();//书名
        String writer = doc.select("div.field > span:nth-child(1)").text().split("：")[1];//作者名
        String type = doc.select("div.field > span:nth-child(2)").text().split("：")[1];//书的类型
        String state = doc.select("div.field > span:nth-child(3)").text().split("：")[1];//书的完成状态
        Integer word_count = Integer.valueOf(doc.select("div.field > span:nth-child(4)").text().split("：")[1].split("万")[0]);//单位：万
        String source = doc.select("div.field > span:nth-child(5)").text().split("：")[1];//来源
        Novel novel = new Novel(name, writer, type, state, word_count, source, n_url, f_url);
        if (!isContainsNC(list_novel, novel.toString())) {
            //如果数据库中没有改novel，则保存起来
            template.update("insert into novel values (null, ?, ?, ?, ?, ?, ?, ?, ?, default)",
                    name, writer, type, state, word_count, source, n_url, f_url);
            System.out.println("[" + ++novel_count + "]" + novel);
        } else {
            System.out.println("[已存在-]" + novel);
        }
        //最后返回id
        return template.queryForObject("select min(id) from novel where name = '" + novel.getName() + "' and writer = '" + novel.getWriter() + "\'", Long.class);
    }

    public void doListUrl(final String list_url, final Long content_id) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        Runnable run = new Runnable() {
            public void run() {
                try {
                    Document document1 = Jsoup.parse(new URL(list_url), 100000);
                    Elements as = document1.select("ul.chapter > li > a");
                    for (Element a : as) {
                        String href = "https://xs.sogou.com/" + a.attr("href");
                        Document doc = null;
                        try {
                            doc = Jsoup.parse(new URL(href), 100000);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String number = doc.select("body > div.reader-main > div.paper-box.paper-article > h1").text().split("第")[1].split("章")[0];//第几章
                        String title = doc.select("body > div.reader-main > div.paper-box.paper-article > h1").text();//章节名
                        Integer word_count = Integer.valueOf(doc.select("div.info").text().split("：")[3].split(" ")[0]);//本章字数Integer.valueOf(s.split("\n")[3].split("：")[1].split(" ")[0])
                        String update_time = doc.select("div.info").text().split("：")[4];//更新时间
                        String cont = doc.select("div#contentWp").text();
                        Content content = new Content(number, title, word_count, update_time, href, cont, content_id);
                        template.update("insert into content values (null, ?, ?, ?, ?, ?, ?, ?, default )",
                                number, title, content_id, word_count, cont, href, update_time);
                        System.out.println("[" + ++content_count + "]" + content);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        es.submit(run);
    }
}