package day_12;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\LEARN\\java\\Java_new_learning\\src\\day_12\\a.txt");
//        File f2 = new File("D:\\LEARN\\java\\Java_new_learning\\src", "day_12\\a.txt");
        File f3 = new File("D:/LEARN/java/Java_new_learning/src/day_12/a.txt");
        File f4 = new File("D:" + File.separator + "/LEARN/java/Java_new_learning/src/day_12/a.txt");
        File f5 = new File("day_12/a.txt");

        System.out.println(f1.getName());//获取文件名称或文件夹名称
        System.out.println(f1.getPath());//获取文件路径或文件名，就是new File时写的路径
        System.out.println(f5.getAbsolutePath());//获取绝对路径
        System.out.println(f5.getAbsoluteFile());//获取用当前文件夹的绝对路径构建的File对象
        System.out.println(f1.getParent());//返回当前文件夹名称或父级路径

        //给文件或文件夹重命名
        f1.renameTo(new File("D:\\LEARN\\java\\Java_new_learning\\src\\day_12\\aa.txt"));

        File f6 = new File("D:\\LEARN\\java\\Java_new_learning\\src\\day_12\\aa.txt");
        System.out.println(f6.exists());//判断文件或文件夹是否存在

        System.out.println(f1.canRead());//判断文件是否可读
        System.out.println(f1.canWrite());//判断文件是否可写

        System.out.println(f1.isFile());//判断当前file对象是不是文件
        System.out.println(f1.isDirectory());//判断当前file对象是不是文件夹或目录

        System.out.println(f1.lastModified());//获取文件的最后修改时间
        System.out.println(f1.length());//获取文件长度

    }

}
