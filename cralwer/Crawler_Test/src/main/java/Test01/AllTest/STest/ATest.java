package Test01.AllTest.STest;

import java.io.FileWriter;
import java.util.HashMap;

public class ATest {
    public static void main(String[] args) throws Exception{
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("唐诗三百", "https://so.gushiwen.cn/gushi/tangshi.aspx");
        map.put("古诗三百", "https://so.gushiwen.cn/gushi/sanbai.aspx");
        map.put("宋词三百", "https://so.gushiwen.cn/gushi/songsan.aspx");
        String all = "p_name*name*dynasty*content*url\n";
        for (String styleName:map.keySet()) {
            String url = map.get(styleName);
            System.out.println("正在爬取" + styleName + "...");
//        逐个类别解析
            all += new SingleTest().singleTest(url);
            System.out.println(styleName + "保存成功!");
        }
//        保存诗歌
        testFileWriter(all, "D:/Test/poems2.0/" + "300.txt");
        System.out.println("Over!");
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
