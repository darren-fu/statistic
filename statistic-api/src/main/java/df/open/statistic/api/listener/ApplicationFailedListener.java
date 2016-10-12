package df.open.statistic.api.listener;

import df.open.statistic.api.common.Log;
import org.slf4j.Logger;
import org.springframework.boot.context.event.ApplicationFailedEvent;
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
public class ApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent> {
    private static Logger log = Log.get();

    public void onApplicationEvent(ApplicationFailedEvent event) {
        Log.warn(log,"ApplicationFailedEvent...");

    }
}
