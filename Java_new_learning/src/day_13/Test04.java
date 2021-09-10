package day_13;

import java.io.*;

/*标准输入输出流*/
public class Test04 {
    public static void main(String[] args) throws Exception {
//        testSystemIn();
//        writeToFile("D:/Test/xiaxie.txt");
        test();
    }

    public static void test() throws Exception {
        //从控制台输入信息
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        //读取文件中的信息
        BufferedReader breader = new BufferedReader(new FileReader("D:/Test/user.txt"));
        char[] ch = new char[100];
        int len = 0;
        String user_code = null;
        while ((len = breader.read(ch)) != -1) {
            user_code = new String(ch, 0, len);
        }

        String str = "";
        while ((str = br.readLine()) != null) {
            if (!str.equals(user_code)) {
                System.out.println("用户名或密码错误！");
            } else if (str.equals("exit")) {
                break;
            } else {
                System.out.println("登录成功！");
            }
        }
    }

    public static void writeToFile(String outPath) throws Exception {
        //创建一个接受键盘输入数据的输入流
        InputStreamReader is = new InputStreamReader(System.in);

        //把输入流放到缓冲流里
        BufferedReader br = new BufferedReader(is);

        //创建缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter(outPath));

        String str = "";

        while ((str = br.readLine()) != null) {
            if (!str.equals("exit")) {
                bw.write(str);
            } else {
                break;
            }
        }

        bw.flush();
        br.close();
        is.close();
    }

    public static void testSystemIn() throws Exception {
        //创建一个接受键盘输入数据的输入流
        InputStreamReader is = new InputStreamReader(System.in);

        //把输入流放到缓冲流里
        BufferedReader br = new BufferedReader(is);

        String str = "";

        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        br.close();
        is.close();
    }

}
