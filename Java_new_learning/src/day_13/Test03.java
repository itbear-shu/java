package day_13;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*转换流
* 当字节流中的数据都是字符的时候，使用转换流转为字符流，效率更高*/
public class Test03 {
    public static void main(String[] args) throws Exception{
        testInputStreamReader();
    }
    public static void testOutputStreamWriter(String Path) throws Exception {
        /*转换字节输出流为字符输出流*/
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(Path), StandardCharsets.UTF_8);
        os.write("abc");

        os.flush();
        os.close();

    }

    public static void testInputStreamReader() throws Exception{
        /*转换字节输入流为字符输入流*/
        FileInputStream fs = new FileInputStream("D:/Test/a.txt");
        InputStreamReader in = new InputStreamReader(fs, StandardCharsets.UTF_8);

        char[] c = new char[100];
        int len = 0;
        while ((len = in.read(c)) != -1) {
            System.out.println(new String(c, 0, len));
        }

        in.close();
        fs.close();
    }

}
