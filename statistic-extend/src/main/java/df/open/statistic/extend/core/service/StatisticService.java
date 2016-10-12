package df.open.statistic.extend.core.service;

import df.open.statistic.extend.core.queue.BatchTakeLinkedBlockingQueue;
import df.open.statistic.extend.tool.StackHelper;
import df.open.statistic.pojo.Invoker;
import df.open.statistic.util.common.DateUtil;
import df.open.statistic.util.common.TimeUtil;
import df.open.statistic.util.enumeration.ResultEnum;
import df.open.statistic.util.enumeration.TypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

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
 * @date 2016/7/26
 */


public class StatisticService {

    private static Logger log = LoggerFactory.getLogger(StatisticService.class);

    private static Invoker EMPTY_INVOKER = new Invoker();

    private BatchTakeLinkedBlockingQueue<Invoker> invokersQueue = null;

//    private StatisticProperties config;

    public StatisticService(BatchTakeLinkedBlockingQueue<Invoker> invokersQueue) {
        this.invokersQueue = invokersQueue;
    }


    public void record(long costTime, String curClassName, String curMethodName) {

    }

    public void record(TypeEnum type, ResultEnum resultEnum, long start, ProceedingJoinPoint jp, Thread currentThread) {
        long end = System.nanoTime();
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        Invoker invoker = EMPTY_INVOKER;
        if (!TypeEnum.CONTROLLER.equals(type)) {
            invoker = StackHelper.analysParentInvoker(currentThread, className);
        }

        long cost = TimeUtil.transNanoToMillSeconds(end - start);

        record(type, resultEnum, cost, 1, className, methodName, invoker.getParentClassName(), invoker.getParentMethodName());
    }


    public void record(TypeEnum type, ResultEnum resultEnum, long cost, Integer count, String curClassName, String curMethodName, String parentClassName, String parentMethodName) {
        if (invokersQueue == null) {
            log.error("没有缓存队列，记录失败...");
        }
        log.warn("{} recorder end : {}:{}, cost:{}", type.getName(), curClassName, curMethodName, cost);

        Invoker invoker = new Invoker();
        invoker.setType(type);
        invoker.setResult(resultEnum);
        invoker.setCost(cost);
        invoker.setCount(count == null ? 1 : count);
        invoker.setClassName(curClassName);
        invoker.setMethodName(curMethodName);
        invoker.setParentClassName(parentClassName);
        invoker.setParentMethodName(parentMethodName);
        invoker.setInvokeTime(DateUtil.getDate());
        if (invokersQueue.append(invoker)) {
            log.debug("队列长度：{}，成功添加记录{}", invokersQueue.size(), invoker.toString());
        }
    }

    public void recordException(long costTime, Class curClz, Method curMethod, Exception exception) {

    }


}
