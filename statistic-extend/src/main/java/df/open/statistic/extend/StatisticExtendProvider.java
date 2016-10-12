package df.open.statistic.extend;

import df.open.statistic.extend.config.StatisticProperties;
import df.open.statistic.extend.core.queue.QueueHolder;
import df.open.statistic.extend.core.service.StatisticService;
import df.open.statistic.extend.core.task.InvokerCollectTaskHolder;
import df.open.statistic.extend.core.task.InvokerProcessTaskHolder;
import df.open.statistic.util.enumeration.ResultEnum;
import df.open.statistic.util.enumeration.TypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
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
 * @date 2016/8/3
 */
public class StatisticExtendProvider {
    private static Logger log = LoggerFactory.getLogger(StatisticExtendProvider.class);

    private StatisticProperties config;

    private volatile StatisticService statisticService;

    private QueueHolder queueHolder = null;

    private InvokerCollectTaskHolder invokerCollectTaskHolder = null;

    private InvokerProcessTaskHolder invokerProcessTaskHolder = null;


    public StatisticExtendProvider(StatisticProperties config) {
        this.config = config == null ? new StatisticProperties() : config;
        log.error("配置属性:{}", config);

        this.queueHolder = QueueHolder.getInstance(this.config);
        this.statisticService = new StatisticService(queueHolder.getInvokerQueue());

        // 初始化 InvokerQueueHolder
        // 初始化 InvokerProcessTaskHolder
        this.invokerProcessTaskHolder = InvokerProcessTaskHolder.getInstance(this.config);
        // 启动处理线程
        this.invokerCollectTaskHolder = InvokerCollectTaskHolder.getInstance(queueHolder.getInvokerQueue(), invokerProcessTaskHolder);
        this.invokerCollectTaskHolder.startTask();

    }

    public void record(StatisticProperties config, ProceedingJoinPoint joinPoint, Thread currentThread) {

    }

    /**
     * @param type
     * @param jp
     * @param currentThread
     * @return
     * @throws Throwable
     */
    public void record(TypeEnum type, long startNanoTime, ProceedingJoinPoint jp, Thread currentThread) {
        statisticService.record(type, ResultEnum.SUCCESS, startNanoTime, jp, currentThread);
    }

    public void record(TypeEnum type, long startNanoTime, ResultEnum resultEnum, ProceedingJoinPoint jp, Thread currentThread) {
        statisticService.record(type, resultEnum, startNanoTime, jp, currentThread);
    }

}
