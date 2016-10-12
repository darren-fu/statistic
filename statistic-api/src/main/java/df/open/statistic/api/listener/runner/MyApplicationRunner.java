package df.open.statistic.api.listener.runner;

import df.open.statistic.api.common.Log;
import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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
 * @date 2016/6/16
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    private static Logger log = Log.get();

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    public void run(ApplicationArguments args) throws Exception {
        Log.warn(log,"ApplicationArguments...");

    }
}
