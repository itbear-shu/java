package day_12;

import java.io.File;

public class Test03 {
    public static void main(String[] args) {
        File f = new File("D:\\Test");

        for (String s: f.list()//返回当前文件夹的子集，包括目录和文件夹
             ) {
            System.out.println(s);
        }
        System.out.println("---------------------");
        for (File s: f.listFiles()//返回当前文件夹的子集的路径
             ) {
            System.out.println(s);
        }
    }
}
