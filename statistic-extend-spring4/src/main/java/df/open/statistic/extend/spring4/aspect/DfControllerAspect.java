package df.open.statistic.extend.spring4.aspect;

import df.open.statistic.util.enumeration.TypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Aspect
public class DfControllerAspect extends AbstractAspect {

    private static Logger log = LoggerFactory.getLogger(DfControllerAspect.class);

    public DfControllerAspect() {

    }

    @Pointcut(value = DF_CONTROLLER_AOP_PATH)
    public void qmController() {
    }


    @Around(value = "qmController()")
    public Object aroundAmController(ProceedingJoinPoint pjp) throws Throwable {
        return doRecord(TypeEnum.CONTROLLER, pjp);
    }

}
