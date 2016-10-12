package df.open.statistic.extend.core.task;

import df.open.statistic.extend.config.StatisticProperties;
import df.open.statistic.pojo.Invoker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

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
 * @date 2016/8/1
 */
public class InvokerProcessTaskHolder {

    private static Logger log = LoggerFactory.getLogger(InvokerProcessTaskHolder.class);


    private static String URL;

    private static String PROJECT;

    private static Integer costBaseLine;

    /**
     * 核心线程数
     */
    private volatile static int MIN_THREADS = 3;
    /**
     * 最大线程数
     */
    private volatile static int MAX_THREADS = 5;
    /**
     * 队列容量，即最大并发处理能力为10（MAX_THREADS + MAX_QUEUE）,超过会reject
     */
    private static final int MAX_QUEUE = 5;
    /**
     * 缓冲队列
     */
    private static BlockingQueue<Runnable> poolQueue = null;
    /**
     * 任务线程池
     */
    private static ThreadPoolExecutor pool = null;//


    private volatile static InvokerProcessTaskHolder invokerProcessTaskHolder = null;

    private InvokerProcessTaskHolder() {
    }

    /**
     * 初始化
     *
     * @param config
     * @return
     */
    public static InvokerProcessTaskHolder getInstance(StatisticProperties config) {
        if (invokerProcessTaskHolder == null) {
            synchronized (InvokerProcessTaskHolder.class) {
                if (invokerProcessTaskHolder == null) {
                    URL = config.getUrl();
                    PROJECT = config.getProject();
                    costBaseLine = config.getBaseline();
                    MIN_THREADS = config.getCoreThreadNum();
                    MAX_THREADS = config.getMaxThreadNum();
                    poolQueue = new LinkedBlockingQueue<>(MAX_QUEUE);
                    pool = new ThreadPoolExecutor(MIN_THREADS, MAX_THREADS, 60L, TimeUnit.SECONDS, poolQueue);
                    invokerProcessTaskHolder = new InvokerProcessTaskHolder();
                }
            }
        }
        return invokerProcessTaskHolder;
    }


    public boolean process(List<Invoker> invokers) {
        InvokerProcessTask task = new InvokerProcessTask(invokers, URL, PROJECT, costBaseLine);
        return process(task);
    }

    public boolean process(InvokerProcessTask task) {
        try {
            pool.execute(task);
        } catch (RejectedExecutionException e) {
            log.warn("拒绝执行任务:{}", task.toString());
            // TODO: 发送日志到分析系统
            return false;
        } catch (Exception e) {
            log.error("发生异常:{}", e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
