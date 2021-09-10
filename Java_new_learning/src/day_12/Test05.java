package day_12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test05 {
    public static void main(String[] args) {

    }

    public static void copyFile(String inPath, String outPath) {
        try {//文件、图片都可
            FileInputStream in = new FileInputStream(inPath);
            FileOutputStream out = new FileOutputStream(outPath);

            byte[] b = new byte[100000000];

            int len = 0;

            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);//写入文件，参数1表示要写入的缓冲数组，参数2是数组开始的位置，参数3是结束的位置
            }

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFileOutputStream() {
        try {
            FileOutputStream out = new FileOutputStream("D:\\Test\\a.txt");
            String str = new String("a");
            out.write(str.getBytes());//把数据写道内存
            out.flush();//把内存中的数据刷写到硬盘
            out.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testFileInputStream() {
        try {
            FileInputStream in = new FileInputStream("D:\\Test\\IMG_1127.jpg");

            byte[] b = new byte[1000000];//设置一个byte数组读取文件的内容

//            in.read(b);//in.read方法有一个返回值，返回值是读取的数据的长度，如果读取到最后一个数据，就会返回-1

            int len = 0;

            while ((len = in.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
                //new String(b, 0, len)参数1是缓冲数据的数组，参数2是开始转化字符串的位置，参数3是总共转换的字符数
            }
//            System.out.println(new String(b));

            in.close();//使用后需要关闭

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
