package df.open.statistic.api.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

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
 * @date 2016/7/19
 */
//@Component
public class ContextRefreshListener implements ApplicationListener<ContextRefreshedEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
//    @PostConstruct
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        ApplicationContext ctx = event.getApplicationContext();
//        DefaultListableBeanFactory acf = (DefaultListableBeanFactory) ctx
//                .getAutowireCapableBeanFactory();
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ControllerAspect.class);
//
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(AspectController.class);
//        acf.registerBeanDefinition("aspectController", beanDefinitionBuilder.getRawBeanDefinition());
//        System.out.println("#########################onApplicationEvent--------");
//        System.out.println(acf.containsBean("aspectController"));
//        System.out.println(acf.containsSingleton("aspectController"));
//        System.out.println(acf.containsLocalBean("aspectController"));
//
//        if (acf.containsBeanDefinition("aspectController")) {
//            acf.removeBeanDefinition("aspectController");
//        }
    }
}
