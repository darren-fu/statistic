package df.open.statistic.extend.core.task;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import df.open.statistic.pojo.Invoker;
import df.open.statistic.util.common.HttpClient;
import df.open.statistic.util.common.ZipUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @date 2016/8/1
 */
public class InvokerProcessTask implements Runnable {

    private static Logger log = LoggerFactory.getLogger(InvokerProcessTask.class);

    private static String ROUTER_PERFORMANCE = "/api/record/performance";
    private static String ROUTER_EXCEPTION = "/api/record/exception";

    private String url;
    private String project;
    private Integer costBaseLine;
    private List<Invoker> invokers;

    public InvokerProcessTask(List<Invoker> invokers, String url, String project, Integer costBaseLine) {
        this.invokers = invokers;
        this.url = url;
        this.project = project;
        this.costBaseLine = costBaseLine;
    }

    @Override
    public void run() {
        if (invokers == null || invokers.size() < 1) {
            return;
        }

        log.error("InvokerProcessTask开始执行，数据量：{}", invokers.size());
        invokers = preProcessInvokers(invokers);
        log.error("数据预处理完成，数据量：{}", invokers.size());

        //处理数据，压缩数据，发送数据
        String content = ZipUtil.gzip(toJSONString(invokers));
        HttpClient http = new HttpClient();
        try {
            String loginUrl = url + ROUTER_PERFORMANCE;
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("project", project));
//            params.add(new BasicNameValuePair("token", "123"));
            params.add(new BasicNameValuePair("data", content));

            http.requestPost(loginUrl, params);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据预处理，归纳耗时过少的数据
     *
     * @param invokers
     * @return
     */
    private List<Invoker> preProcessInvokers(List<Invoker> invokers) {
        Map<String, Invoker> underBaseLineInvokers = new HashMap<>();

        List<Invoker> processInvokers = new ArrayList<>(invokers.size() / 2);
        for (Invoker invoker : invokers) {
            //超过基线的直接加入
            if (invoker.getCost() > costBaseLine) {
                processInvokers.add(invoker);
            } else if (underBaseLineInvokers.containsKey(invoker.getKey())) {
                // 小于的放入归纳map中，合并成一条
                Invoker underBaseLineInvoker = underBaseLineInvokers.get(invoker.getKey());
                underBaseLineInvoker.increaseCount(1);
                underBaseLineInvoker.increaseCost(invoker.getCost());
            } else {
                underBaseLineInvokers.put(invoker.getKey(), invoker);
            }
        }
        processInvokers.addAll(underBaseLineInvokers.values());
        return processInvokers;
    }


    /**
     * 强制enum转json输出value而不是name
     *
     * @param object
     * @param features
     * @return
     */
    public static final String toJSONString(Object object, SerializerFeature... features) {
        SerializeWriter out = new SerializeWriter();

        try {
            JSONSerializer serializer = new JSONSerializer(out);
            serializer.config(SerializerFeature.WriteEnumUsingToString, false);
            for (com.alibaba.fastjson.serializer.SerializerFeature feature : features) {
                serializer.config(feature, true);
            }

            serializer.write(object);

            return out.toString();
        } finally {
            out.close();
        }
    }


}
