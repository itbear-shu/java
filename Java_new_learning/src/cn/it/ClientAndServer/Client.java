package cn.it.ClientAndServer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        //1.创建FileInputStream对象，读取本地文件的内容
        FileInputStream fis = new FileInputStream("D:\\Test\\a.txt");
        //2.创建一个客户端对象Socket，绑定host和port
        Socket socket = new Socket("127.0.0.1", 8888);
        //3.使用网络字节输出流OutputStream对象的write方法向服务器端发送数据
        OutputStream os = socket.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        //4.使用网络字节输入流InputStream对象的read方法读取服务器端回写的数据
        InputStream inputStream = socket.getInputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //5.释放资源
        fis.close();
        socket.close();
    }
}
