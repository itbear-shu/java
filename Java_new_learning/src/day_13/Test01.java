package day_13;

import java.io.*;

public class Test01 {
    public static void main(String[] args) throws Exception {
//        testBufferedInputStream();
//        testBufferedOutputStream("Hello World!", "D:/Test/hello.txt");
        copyFile("D:/Test/a.txt", "D:/Test/aa.txt");
    }

    public static void copyFile(String inPath, String outPath) throws Exception {
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(inPath));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(outPath));

        byte[] b = new byte[1024];
        int len = 0;
        while((len = bi.read(b)) != -1) {
            bo.write(b, 0, len);
        }

        bo.close();
        bi.close();

    }

    public static void testBufferedOutputStream(String text, String outPath) throws Exception {
        //创建字节输出流对象
        FileOutputStream out = new FileOutputStream(outPath);
        //把字节输出流放到缓存字节输出流中
        BufferedOutputStream bo = new BufferedOutputStream(out);

        bo.write(text.getBytes());

        bo.flush();
        bo.close();
        out.close();
    }


    public static void testBufferedInputStream() throws Exception {
        //创建文件字节输入流对象
        FileInputStream in = new FileInputStream("D:/Test/a.txt");
        //把文件字节输入流放到缓冲字节输入流对象
        BufferedInputStream br = new BufferedInputStream(in);

        byte[] b = new byte[1024];

        int len = 0;

        while ((len = br.read(b)) != -1) {
            System.out.println(new String(b, 0, len));
        }

        //关闭流时：最晚开的最早关，依次关
        br.close();
        in.close();
    }
}
