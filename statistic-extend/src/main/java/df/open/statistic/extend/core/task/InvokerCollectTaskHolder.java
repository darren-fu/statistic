package df.open.statistic.extend.core.task;

import df.open.statistic.extend.core.queue.BatchTakeLinkedBlockingQueue;
import df.open.statistic.pojo.Invoker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

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
public class InvokerCollectTaskHolder {

    private static Logger log = LoggerFactory.getLogger(InvokerCollectTaskHolder.class);

    /**
     * 启动标志
     */
    private AtomicBoolean hasStarted;

    /**
     * 数据收集任务
     */
    private CollectTask collectTask;

    /**
     * 单线程池
     */
    private ExecutorService collectTaskPool;

    /**
     * 数据存缓存queue
     */
    private BatchTakeLinkedBlockingQueue invokerQueue;

    /**
     * 数据处理任务
     */
    private InvokerProcessTaskHolder invokerProcessTaskHolder;

    /**
     * self
     */
    private static InvokerCollectTaskHolder invokerCollectTaskHolder;

    private InvokerCollectTaskHolder(BatchTakeLinkedBlockingQueue invokerQueue, InvokerProcessTaskHolder invokerProcessTaskHolder) {
        this.invokerQueue = invokerQueue;
        this.invokerProcessTaskHolder = invokerProcessTaskHolder;
        collectTask = new CollectTask();
        this.hasStarted = new AtomicBoolean(false);
        this.collectTaskPool = Executors.newSingleThreadExecutor();
    }

    public static InvokerCollectTaskHolder getInstance(BatchTakeLinkedBlockingQueue invokerQueue, InvokerProcessTaskHolder invokerProcessTaskHolder) {
        if (invokerCollectTaskHolder == null) {
            synchronized (InvokerCollectTaskHolder.class) {
                if (invokerCollectTaskHolder == null) {
                    invokerCollectTaskHolder = new InvokerCollectTaskHolder(invokerQueue, invokerProcessTaskHolder);
                }
            }
        }
        return invokerCollectTaskHolder;
    }


    public void startTask() {
        //如果未启动，则启动，设置标志为true
        if (hasStarted.compareAndSet(false, true)) {
            FutureTask<Object> futureTask = new FutureTask<>(collectTask);
            collectTaskPool.execute(futureTask);
        } else {
            //已经启动
        }
    }


    public void stopTask() {
        collectTask.setCollect(false);
    }

    /**
     * 数据收集，并启动处理任务
     */
    class CollectTask implements Callable<Object> {

        private volatile boolean collect = true;

        public CollectTask() {
        }


        @Override
        public Object call() throws Exception {
            if (invokerQueue == null) {
                throw new IllegalArgumentException("参数错误无法执行");
            }
            List<Invoker> invokers;
            while (collect) {
                log.debug("数据收集中...");
                try {

                    // 数据收集
                    invokers = invokerQueue.takeBatch();
                    if (invokers != null && invokers.size() > 0) {
                        log.debug("获得数据:{}条,剩余：{}条", invokers.size(), invokerQueue.size());

                        // 数据处理
                        boolean result = invokerProcessTaskHolder.process(invokers);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "执行完成,collect:" + collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }
    }
}
