package cn.itcast.crawler.test;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static org.apache.http.client.config.RequestConfig.*;
//请求参数
public class HttpConfigTest {
    public static void main(String[] args) {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpGet对象,设置url访问
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        //配置请求信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) //设置连接的最长时间，单位ms
                .setConnectionRequestTimeout(500)  //设置获取连接的最长时间，单位ms
                .setSocketTimeout(10*1000) //设置数据传输的最长时间，单位ms
                .build();

        //给请求设置请求信息
        httpGet.setConfig(config);

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求,获取response
            response = httpClient.execute(httpGet);

            //解析响应
            if(response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content.length());
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
}
