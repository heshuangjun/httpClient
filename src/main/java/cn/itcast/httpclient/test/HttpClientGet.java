package cn.itcast.httpclient.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author heshuangjun
 * @date 2018-11-12 18:20
 */
public class HttpClientGet {
    public static void main(String[] args) throws IOException {
        //1.模拟打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.设置请求对象
        HttpGet httpGet = new HttpGet("http://www.baidu.com/s?wd=java");
        //3.发起请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        //4.基于状态码判断
        if(httpResponse.getStatusLine().getStatusCode()==200){
            //响应成功
            HttpEntity entity = httpResponse.getEntity();
            //输出显示返回结果
            String string = EntityUtils.toString(entity, "utf-8");
            System.out.println(string);
        }
        //5.关闭资源
        httpResponse.close();
        httpClient.close();
    }
}
