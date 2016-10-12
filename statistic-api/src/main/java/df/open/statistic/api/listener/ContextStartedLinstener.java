package df.open.statistic.api.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

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
 * @date 2016/7/20
 */
//@Component
public class ContextStartedLinstener implements ApplicationListener<ContextStartedEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("#########ContextStartedEvent-----------------------");
    }
}
