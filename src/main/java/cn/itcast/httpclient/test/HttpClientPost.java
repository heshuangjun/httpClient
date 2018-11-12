package cn.itcast.httpclient.test;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heshuangjun
 * @date 2018-11-12 18:20
 */
public class HttpClientPost {
    public static void main(String[] args) throws IOException {
        //1.模拟打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.设置请求对象
        HttpPost httpPost = new HttpPost("https://www.oschina.net/");

        //组装post请求的参数 scope=project&q=java
        List<NameValuePair> parameter = new ArrayList<NameValuePair>();
        parameter.add(new BasicNameValuePair("scope", "project"));
        parameter.add(new BasicNameValuePair("q", "java"));

        //组装表单实体对象(把参数组装到表单中)
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameter,"utf-8");
        httpPost.setEntity(formEntity);


        //开源中国,设置请求头
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:63.0) Gecko/20100101 Firefox/63.0");

        //3.发起请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        //4.基于状态码判断
        //响应成功
        HttpEntity entity = httpResponse.getEntity();
        //输出显示返回结果
        String string = EntityUtils.toString(entity, "utf-8");
        System.out.println(string);
        //5.关闭资源
        httpResponse.close();
        httpClient.close();
    }
}
