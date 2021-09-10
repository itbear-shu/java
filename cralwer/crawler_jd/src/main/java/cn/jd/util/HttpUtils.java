package cn.jd.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.util.UUID;

@Component
public class HttpUtils {
    private PoolingHttpClientConnectionManager cm;

    public HttpUtils() {
        this.cm = new PoolingHttpClientConnectionManager();

        //设置最大连接数
        this.cm.setMaxTotal(100);

        //设置每个主机最大连接数
        this.cm.setDefaultMaxPerRoute(10);
    }

    //根据请求地址下载页面数据
    public String doGetHtml(String url) throws Exception {
        //获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();

        //创建HttpGet请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);

        //设置请求信息
        httpGet.setConfig(this.getConfig());

        // 设置请求头, 伪装用户
        this.setHeaders(httpGet);


        CloseableHttpResponse response = null;
        //使用HttpClient发起请求，获取响应
        try {
            response = httpClient.execute(httpGet);

            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应体Entity是否为空，如果不为空就可以使用EntityUtils
                if(response.getEntity() != null) {
                    String content = EntityUtils.toString(response.getEntity(), "utf8");
                    return content;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭response
            if(response != null) {
                response.close();
            }
        }
        //返回空字符串
        return "";
    }



    //下载图片,返回图片名称
    public String doGetImage(String url) throws Exception{
        //获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();

        //创建HttpGet请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);

        //设置请求信息
        httpGet.setConfig(this.getConfig());

        // 设置请求头, 伪装用户
        this.setHeaders(httpGet);

        CloseableHttpResponse response = null;
        //使用HttpClient发起请求，获取响应
        try {
            response = httpClient.execute(httpGet);

            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应体Entity是否为空，如果不为空就可以使用EntityUtils
                if(response.getEntity() != null) {
                    //下载图片
                    //获取图片后缀
                    String extName = url.substring(url.lastIndexOf("."));

                    //创建图片名，重命名图片
                    String picName = UUID.randomUUID().toString() + extName;

                    //下载图片
                    response.getEntity().writeTo(new FileOutputStream("D:/Test/images/" + picName));

                    //返回图片名称
                    return picName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭response
            if(response != null) {
                response.close();
            }
        }
        //返回空字符串
        return "";

    }

    //设置请求信息
    private RequestConfig getConfig() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(10000) //创建连接最长时间
                .setConnectionRequestTimeout(5000) //获取连接最长时间
                .setSocketTimeout(100000) //数据传输最长时间
                .build();
        return config;
    }

    private void setHeaders(HttpGet httpGet) {
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36 Edg/91.0.864.59");

    }
}
