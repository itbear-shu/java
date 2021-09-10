package cn.it.ClientAndServer;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws Exception {
        while (true) {
            synchronized (new Object()) {
                //1.创建ServerSocket对象，指定端口号
                ServerSocket serverSocket = new ServerSocket(8888);
                //2.使用ServerSocket对象中的方法accept，获取请求到的客户端对象Socket
                Socket socket = serverSocket.accept();
                //3.使用网络字节输入流InputStream对象的read方法读取客户端发送过来的数据
                InputStream inputStream = socket.getInputStream();
                //4.创建本地字节输出流对象FileOutputStream
                long fileName = System.currentTimeMillis() + new Random().nextInt(1000000);
                FileOutputStream fos = new FileOutputStream("D:\\Test\\" + fileName + ".txt");
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = inputStream.read(bytes)) != -1) {
                    fos.write(bytes);
                }
                socket.shutdownInput();
                //5.创建网络字节输出流OutputStream对象回写客户端的数据
                socket.getOutputStream().write("Copy!".getBytes(StandardCharsets.UTF_8));
                //6.释放资源
                serverSocket.close();
                socket.close();
                fos.close();
            }
        }
    }
}
