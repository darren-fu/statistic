package df.open.statistic.extend.spring4.aspect;

import df.open.statistic.util.enumeration.TypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

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
 * @date 2016/7/15
 */
@Aspect
public class DfServiceAspect extends AbstractAspect {


    public DfServiceAspect() {

    }

    @Pointcut(value = DF_SERVICE_AOP_PATH)
    public void qmService() {

    }

    @Around(value = "qmService()")
    public Object aroundQmService(ProceedingJoinPoint pjp) throws Throwable {
        return doRecord(TypeEnum.SERVICE, pjp);
    }

}
