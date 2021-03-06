package df.open.statistic.api.listener;

import df.open.statistic.api.common.Log;
import org.slf4j.Logger;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

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
 * @date 2016/6/16
 */
public class ApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {
    private static Logger log = Log.get();

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        Log.warn(log,"ApplicationPreparedEvent...");

    }
}
