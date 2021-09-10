package day_12;

import java.io.File;

public class Test04 {
    public static void main(String[] args) {
        File f = new File("D:\\Test");
        test(f);
    }

    public static void test(File f) {//递归遍历目录和文件
        if (f.isFile()) {
            System.out.println(f.getAbsolutePath() + " is a file.");
        } else {
            System.out.println(f.getAbsolutePath() + " is a directory.");
            File[] files = f.listFiles();
            if(files != null && files.length > 0) {
                for (File ff: files
                     ) {
                    test(ff);
                }
            }
        }
    }
}

