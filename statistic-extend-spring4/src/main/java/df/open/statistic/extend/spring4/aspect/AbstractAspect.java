package df.open.statistic.extend.spring4.aspect;


import df.open.statistic.extend.StatisticExtendProvider;
import df.open.statistic.util.enumeration.TypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

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
 * @date 2016/7/27
 */
public abstract class AbstractAspect {

    protected static final String DF_CONTROLLER_AOP_PATH = "execution(* df.open..*.*(..))" +
            " && @target(org.springframework.web.bind.annotation.RestController) " +
            " && @annotation(org.springframework.web.bind.annotation.RequestMapping)";

    protected static final String DF_SERVICE_AOP_PATH = "execution(public * df.open..*.*(..))" +
            " && within(@org.springframework.stereotype.Service *)";

    @Autowired
    protected StatisticExtendProvider statisticExtendProvider;


    protected Object doRecord(TypeEnum type, ProceedingJoinPoint pjp) {
        Object o = null;
        try {
            long start = System.nanoTime();
            o = pjp.proceed();
            statisticExtendProvider.record(type, start, pjp, Thread.currentThread());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }


}
