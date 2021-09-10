package cn.itcast.crawler.test_copy;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpGetParamTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URIBuilder uriBuilder = new URIBuilder("http://www.baidu.com/s");
        uriBuilder.setParameter("wd", "java");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        System.out.println("发起请求的信息是：" + httpGet);


        CloseableHttpResponse response = httpClient.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf-8");

            System.out.println(content);
        }

        response.close();
        httpClient.close();
    }
}
