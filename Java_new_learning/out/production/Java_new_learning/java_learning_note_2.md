## 16-6 TCP通信程序

**概述**：TCP通信时面向连接的通信，客户端和服务器端必须通过3次握手，建立逻辑连接，才能通信安全。

通信步骤：

+ 服务器端先启动
+ 服务器端不会主动请求客户端，必须使用客户端请求服务器端
+ 客户端和服务器端就会建立一个逻辑连接，而这个连接中包含一个对象--**IO对象**
+ 客户端和服务器端时有IO对象进行通信，通信的对象不仅仅是字符，所以IO对象是**字节流对象**。

客户端和服务器端进行一个数据交互需要4个IO流对象。

![TCP](D:\BaiduNetdiskWorkspace\LEARN\java\Java_new_learning\src\note.assets\2021-08-26 115220.jpg)

### 16-6-1 客户端

TCP通信的**客户端**：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据。

表示客户端的类：

+ java.net.Socket：此类实现客户端**套接字**。
+ 套接字：包含了IP地址和端口号的网络单位。套接字是两台机器间通信的端点。

构造方法：

+ `Socket(String host, int port)`创建流套接字并将其连接到指定主机上的指定端口号。
  + host：服务器端逐渐的名称/ip地址
  + port：服务器端的端口号

成员方法：

| 返回值类型     | 方法名及用法                              |
| -------------- | ----------------------------------------- |
| `InputStream`  | `getInputStream()`返回此套接字的输入流。  |
| `OutputStream` | `getOutputStream()`返回此套接字的输出流。 |
| `void`         | `close()`关闭此套接字。                   |

实现步骤：

```java
public static void main(String[] args) {
        try {
            //1.创建一个客户端对象Socket，绑定host和port
            Socket soc = new Socket("127.0.0.1", 8888);
            //2.使用Socket对象中的方法getOutputStream获取网络字节输出流OutputStream对象
            OutputStream outputStream = soc.getOutputStream();
            //3.使用网络字节输出流OutputStream对象的write方法向服务器端发送数据
            outputStream.write("Hello, World!".getBytes());
            //4.使用Socket对象中的方法getInputStream获取网络字节输入流InputStream对象
            InputStream inputStream = soc.getInputStream();
            //5.使用网络字节输入流InputStream对象的read方法读取服务器端回写的数据
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));
            //6.是否Socket对象
            soc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
```

### 16-6-2 服务器端

TCP通信的**服务器端**：接受客户端的请求，读取客户端发送的数据，给客户端回写数据。

表示服务器的类：

+ java.net.ServerSocket：实现了服务器套接字。

构造方法：

`ServerSocket(int port)`创建绑定到指定端口的服务器套接字。

成员方法：

| `Socket` | `accept()`侦听要连接到此套接字并接受它。 |
| -------- | ---------------------------------------- |

实现步骤：

```java
public static void main(String[] args) {
    try {
        //1.创建服务器ServerSocket对象和系统要指定的端口号port
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.使用ServerSocket对象中的方法accept，获取请求到的客户端对象Socket
        Socket socket = serverSocket.accept();
        //3.使用Socket对象中的方法getInputStream获取网络字节输入流InputStream对象
        InputStream inputStream = socket.getInputStream();
        //4.使用网络字节输入流InputStream对象的read方法读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //5.使用Socket对象中的方法getOutputStream获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();
        //6.使用网络字节输出流OutputStream对象的write方法向客户端回写数据
        outputStream.write("Copy!".getBytes());
        //7.释放Socket, ServerSocket资源
        socket.close();
        serverSocket.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

## 16-7 综合案例

### 16-7-1 文件上传案例

TCP通信上传文件原理：客户端读取本地文件，把文件上传到服务器端，服务器在把上传的文件保存到服务器的硬盘上。实际上就是文件的复制。

使用步骤：

```java

```

注意：

+ 服务器和客户端使用本地硬盘进行读取，需要使用自己创建的字节流（本地流）对象。
+ 服务器端和客户端进行读写，使用Socket对象提供的网络字节流对象（网络流）。

明确：数据源+目的地

**出现问题**：inputStream.read(bytes))读取不到文件的结束标记，read进入**阻塞**状态，一直到死循环等待结束标记，使代码不能停止。

解决方案：上传完文件，给服务器写一个结束标记。



