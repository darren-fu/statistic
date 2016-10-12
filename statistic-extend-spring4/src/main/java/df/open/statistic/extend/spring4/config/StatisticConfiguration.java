package df.open.statistic.extend.spring4.config;

import df.open.statistic.extend.StatisticExtendProvider;
import df.open.statistic.extend.spring4.aspect.DfControllerAspect;
import df.open.statistic.extend.spring4.aspect.DfServiceAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

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
@Configuration
@ComponentScan(basePackages = {"df.open.satistic.extend"})
@Conditional(StatisticAopCondition.class)
//@ConditionalOnProperty(prefix = "qianmi.api.log.method.cost", name = "enable", havingValue = "true")
public class StatisticConfiguration {

    private static Logger log = LoggerFactory.getLogger(StatisticConfiguration.class);

    @Autowired
    private ConfigurableStatisticProperties statisticConfig;


    @Bean
    public StatisticExtendProvider statisticExtendProvider() {
        return new StatisticExtendProvider(statisticConfig);
    }


    @Bean
    public DfControllerAspect qmControllerAspectTest() {
        System.out.println("######################qmControllerAspectTest");
        return new DfControllerAspect();
    }

    @Bean
    public DfServiceAspect qmServiceAspect() {
        System.out.println("######################StatisticAopCondition");

        return new DfServiceAspect();
    }


}
