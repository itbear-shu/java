package day_12;

import java.io.File;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) {
        String pathname = "D:\\LEARN\\java\\Java_new_learning\\src\\day_12\\1.txt";
        File f = new File(pathname);//创建文件
        if(!f.exists()) {//判断是否存在
            try {
                f.createNewFile();//创建新的文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        f.delete();//删除文件
    }
}
