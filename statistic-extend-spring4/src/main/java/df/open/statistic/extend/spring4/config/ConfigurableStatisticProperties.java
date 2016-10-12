package df.open.statistic.extend.spring4.config;

import com.alibaba.fastjson.JSON;
import df.open.statistic.extend.config.StatisticProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

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
 * @date 2016/8/3
 */
@Component("statisticConfig")
@Primary
//@PropertySource("classpath:application.properties")
public class ConfigurableStatisticProperties extends StatisticProperties {

    @Value("${statistic.enable}")
    private Boolean enable;

    @Value("${statistic.project}")
    private String project;

    @Value("${statistic.url}")
    private String url;

    @Value("${statistic.baseline}")
    private int baseline;


    public int getBaseline() {
        return baseline;
    }

    public void setBaseline(int baseline) {
        this.baseline = baseline;
    }

    @Override
    public Boolean getEnable() {
        return enable;
    }

    @Override
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String getProject() {
        return project;
    }

    @Override
    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
