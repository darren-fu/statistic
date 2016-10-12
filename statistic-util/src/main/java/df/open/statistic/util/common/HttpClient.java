package df.open.statistic.util.common;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.H;

/**
 * 说明:
 * <p/>
 * Copyright: Copyright (c)
 * <p/>
 * Company: 江苏千米网络科技有限公司
 * <p/>
 *
 * @author 付亮(OF2101)
 * @version 1.0.0
 * @date 2016/8/13
 */
public class HttpClient {
    private static final int STATUSCODE = 200;
    private static String ENCODE = "utf-8";

    /**
     * get
     *
     * @param urlWithParams
     * @throws Exception
     */
    public void requestGet(String urlWithParams) throws Exception {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpGet httpget = new HttpGet(urlWithParams);

        //配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(50)
                .setConnectTimeout(50)
                .setSocketTimeout(50).build();
        httpget.setConfig(requestConfig);

        CloseableHttpResponse response = httpclient.execute(httpget);
        System.out.println("StatusCode -> " + response.getStatusLine().getStatusCode());

        HttpEntity entity = response.getEntity();
        String jsonStr = EntityUtils.toString(entity);//, "utf-8");
        System.out.println(jsonStr);

        httpget.releaseConnection();
    }

    /**
     * post
     *
     * @param url
     * @param params
     * @throws IOException
     */
    public String requestPost(String url, List<NameValuePair> params) throws IOException {
        String resultStr = null;
        CloseableHttpClient httpclient = null;
        try {
            httpclient = HttpClientBuilder.create().build();

            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = httpclient.execute(httppost);

            if (response.getStatusLine().getStatusCode() == STATUSCODE) {
                resultStr = EntityUtils.toString(response.getEntity(), ENCODE);
                if (resultStr != null) {
                    resultStr = resultStr.trim();
                }
                EntityUtils.consume(response.getEntity());
            } else {
                resultStr = response.getStatusLine().toString();
            }

            httppost.releaseConnection();
        } catch (Exception ex) {

        } finally {
            if (httpclient != null) {
                httpclient.close();
            }
        }
        System.out.println(resultStr);
        return resultStr;
    }

    public static void main(String[] args) {
//        HttpClient http = new HttpClient();
//        try {
//            String loginUrl = "http://localhost:9000/statistic/api/record/performance";
//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            params.add(new BasicNameValuePair("project", "zhang"));
//            params.add(new BasicNameValuePair("token", "123"));
//
//            http.requestPost(loginUrl, params);
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
