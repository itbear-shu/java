package day_12;

import java.io.File;

public class Test02 {
    public static void main(String[] args) {
        File f = new File("D:\\test");
        f.mkdir();//创建单层目录

        File f1 = new File("D:\\test\\a\\b\\c\\d");
        f1.mkdirs();//创建多层目录
    }
}
