package com.me.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmlGet {
    public void getHtml(String url, String outPath) throws Exception{
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpGet对象,设置url访问
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求,获取response
            response = httpClient.execute(httpPost);

            //解析响应
            if(response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                BufferedOutputStream(content, outPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭response
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void BufferedOutputStream(String text, String outPath) throws Exception {
        //创建字节输出流对象
        FileOutputStream out = new FileOutputStream(outPath);
        //把字节输出流放到缓存字节输出流中
        BufferedOutputStream bo = new BufferedOutputStream(out);

        bo.write(text.getBytes());

        bo.flush();
        bo.close();
        out.close();
    }
}
