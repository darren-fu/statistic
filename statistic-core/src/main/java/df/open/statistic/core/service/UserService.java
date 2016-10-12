package df.open.statistic.core.service;

import df.open.statistic.util.common.Log;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
 * @date 2016/7/21
 */
@Service
public class UserService {
    private static Logger log = Log.get();

    @Resource
    private StatisticService statisticService;

    public void login(String userName, String password) {
        log.debug("loging service impl: name{},pwd:{}", userName, password);
//        statisticService.getAvg();
        testPublic();
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void testPublic(){
        log.debug("just test public service aop");
    }

    private void test(){
        log.warn("just test");
    }
}
