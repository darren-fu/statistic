package df.open.statistic.extend.core.queue;

import df.open.statistic.extend.config.StatisticProperties;
import df.open.statistic.extend.core.task.InvokerProcessTaskHolder;
import df.open.statistic.pojo.Invoker;
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
 * @date 2016/8/13
 */
public class QueueHolder {
    private static Logger log = LoggerFactory.getLogger(QueueHolder.class);

    private volatile BatchTakeLinkedBlockingQueue<Invoker> invokersQueue = null;

    private final Object queueMonitor = new Object();

    private StatisticProperties config;

    private static QueueHolder queueHolder = null;

    private QueueHolder(StatisticProperties config) {
        this.config = config;
        if (invokersQueue == null) {
            invokersQueue = new BatchTakeLinkedBlockingQueue<>(config.getRecordQeueuSize(), config.getRecordQeueuTakeSize());
        }
    }

    /**
     * 初始化
     *
     * @param config
     * @return
     */
    public static QueueHolder getInstance(StatisticProperties config) {
        if (queueHolder == null) {
            synchronized (InvokerProcessTaskHolder.class) {
                if (queueHolder == null) {
                    queueHolder = new QueueHolder(config);
                }
            }
        }
        return queueHolder;
    }


    /**
     * 清空queue
     */
    public void clearQueue() {
        if (queueHolder != null) {
            queueHolder.invokersQueue.clear();
        }
    }

    public static void destroyQueue() {
        if (queueHolder != null) {
            queueHolder.invokersQueue = null;
        }
    }

    public BatchTakeLinkedBlockingQueue<Invoker> getInvokerQueue() {
        if (queueHolder != null) {
            return queueHolder.invokersQueue;
        }
        return null;
    }

}
