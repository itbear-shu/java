import First.Content;
import First.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test01()
    {
        String s = "\n" +
                "            小说：爱在机场那一秒 \n" +
                "            作者：灵动的小溪 \n" +
                "            字数：1879 \n" +
                "            更新时间：2013-08-03 02:43:54\n" +
                "        ";
        Integer number = Integer.valueOf(s.split("\n")[3].split("：")[1].split(" ")[0]);
        System.out.println(number);
//        System.out.println(strings.length);
//        for (String string : strings) {
//            System.out.println(string);
//        }
    }

    @org.junit.Test
    public void test02()
    {
        String s = "\n" +
                "            小说：爱在机场那一秒 \n" +
                "            作者：灵动的小溪 \n" +
                "            字数：1879 \n" +
                "            更新时间：2013-08-03 02:43:54\n" +
                "        ";
        String[] strings = s.split("\n");
//        for (String string : strings) {
//            System.out.println(string);
//        }
        System.out.println(strings[4].split("：")[1]);
    }

    @org.junit.Test
    public void test03() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        List<Content> list_content = template.query("select 'number', 'title', 'word_count', 'update_time', 'url', 'cont', 'content_id' from content", new BeanPropertyRowMapper<Content>(Content.class));
        for (Content content : list_content) {
            System.out.println(content.toString());
        }
    }

    @org.junit.Test
    public void test04() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp";
        String s = "{name=齐钥医女之千沉漓, writer=雨声聚来, type=穿越, state=完本, word_count=47, source=起点文学网, n_url=https://xs.sogou.com/book/4579119319/, f_url=https://yue07.sogoucdn.com/cdn/image/book/4579119319_1553517577385.jpg}";
        List<Map<String, Object>> list_novel = template.queryForList("select name, writer, type, state, word_count, source, n_url, f_url from novel");
        for (Map<String, Object> novel_map : list_novel) {
            if(novel_map.toString().equals(s)) {
                System.out.println(novel_map);
            }
        }
//        Map<String, Object> map = template.queryForMap(sql);
//        System.out.println(map);
        if(list_novel.contains(s)) {
            System.out.println(1);
        }
    }

    @org.junit.Test
    public void test05() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        List<Map<String, Object>> list_content = template.queryForList("select * from content");
        for (Map<String, Object> stringObjectMap : list_content) {
            System.out.println(stringObjectMap);
        }
    }

    @org.junit.Test
    public void test06() {
        Date date = new Date();
        System.out.println(date);
    }


}
