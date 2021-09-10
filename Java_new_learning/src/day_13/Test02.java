package day_13;

import java.io.*;

public class Test02 {
    public static void main(String[] args) throws Exception {
        testBufferedFileReader("D:/Test/aa.txt");
        testBufferedFileWriter("Hello", "D:/Test/aaa.txt");
        copyFile("D:/Test/a/note.md", "D:/Test/a/b/nb.md");
    }

    public static void copyFile(String inPath, String outPath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(inPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outPath));

        char[] ch = new char[100];
        int len = 0;
        while ((len = br.read(ch)) != -1) {
            bw.write(ch);
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static void testBufferedFileWriter(String text, String outPath) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(outPath));

        bw.write(text);

        bw.flush();
        bw.close();
    }


    public static void testBufferedFileReader(String inPath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(inPath));
        char[] ch = new char[100];
        int len = 0;
        while ((len = br.read(ch)) != -1) {
            System.out.println(new String(ch, 0, len));
        }
        br.close();
    }
}
