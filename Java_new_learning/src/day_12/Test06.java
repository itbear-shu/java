package day_12;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.io.*;

public class Test06 {
    public static void main(String[] args) {
        testFileReader("D:\\Test\\a.txt");

        testFileWriter("好耶", "D:\\Test\\a.txt");

        copyFile("D:/Test/note.md", "D:/Test/a/notte.md");
    }

    public static void copyFile(String inPath, String outPath) {//文件字符
        try {
            FileReader fr = new FileReader(inPath);
            FileWriter fw = new FileWriter(outPath);

            char[] ch = new char[1024];

            int len = 0;

            while ((len = fr.read(ch)) != -1) {
                fw.write(ch, 0, len);
            }

            fw.flush();

            fw.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static void testFileReader(String inPath) {
        try {
            //创建文件字符输入流的对象
            FileReader fr = new FileReader(inPath);

            char[] ch = new char[1024];//创建字符数组

            int len = 0;

            while ((len = fr.read(ch)) != -1) {
                System.out.println(new String(ch, 0, len));
                //字符名，开始位置，结束位置
            }

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
