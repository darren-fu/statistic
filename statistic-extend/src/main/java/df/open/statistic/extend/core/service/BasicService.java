package df.open.statistic.extend.core.service;

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
 * @date 2016/8/11
 */
public class BasicService {

//    private StatisticProperties config;
//
//    private static BatchTakeLinkedBlockingQueue<Invoker> invokersQueue = null;
//
//    private InvokerCollectTaskHolder invokerCollectTaskHolder = null;
//
//    private InvokerProcessTaskHolder invokerProcessTaskHolder = null;
//
//    public BasicService() {
//        init(null);
//    }
//
//    public BasicService(StatisticProperties config) {
//        init(config);
//    }
//
//    private void init(StatisticProperties config) {
//        if (config == null) {
//            this.config = new StatisticProperties();
//        }
//        invokersQueue = new BatchTakeLinkedBlockingQueue<>(config.getRecordQeueuSize(), config.getRecordQeueuTakeSize());
//        //初始化     InvokerQueueHolder
//        // 初始化   InvokerProcessTaskHolder
//        invokerProcessTaskHolder = InvokerProcessTaskHolder.getInstance(this.config);
//        // 启动处理线程
//        invokerCollectTaskHolder = InvokerCollectTaskHolder.getInstance(invokersQueue, invokerProcessTaskHolder);
//        invokerCollectTaskHolder.startTask();
//    }
//
//
//    public static BatchTakeLinkedBlockingQueue<Invoker> getInvokersQueue() {
//        return invokersQueue;
//    }
//
//    public static void setInvokersQueue(BatchTakeLinkedBlockingQueue<Invoker> invokersQueue) {
//        BasicService.invokersQueue = invokersQueue;
//    }
//
//    public InvokerCollectTaskHolder getInvokerCollectTaskHolder() {
//        return invokerCollectTaskHolder;
//    }
//
//    public void setInvokerCollectTaskHolder(InvokerCollectTaskHolder invokerCollectTaskHolder) {
//        this.invokerCollectTaskHolder = invokerCollectTaskHolder;
//    }
//
//    public InvokerProcessTaskHolder getInvokerProcessTaskHolder() {
//        return invokerProcessTaskHolder;
//    }
//
//    public void setInvokerProcessTaskHolder(InvokerProcessTaskHolder invokerProcessTaskHolder) {
//        this.invokerProcessTaskHolder = invokerProcessTaskHolder;
//    }
}
