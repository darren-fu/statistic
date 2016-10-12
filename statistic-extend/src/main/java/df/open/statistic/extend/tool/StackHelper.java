package df.open.statistic.extend.tool;

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
 * @date 2016/7/20
 */
public class StackHelper {
    private static Logger log = LoggerFactory.getLogger(StackHelper.class);


    /**
     * 从线程栈中获取上级调用类和方法
     * StackTraceElement[] stem = Thread.currentThread().getStackTrace();
     *
     * @param curentThread
     * @return
     */
    public static Invoker analysParentInvoker(Thread curentThread, String curentName) {
        Invoker ivk = new Invoker();
        if (curentThread == null) {
            return ivk;
        }

        StackTraceElement[] stackTraceElements = curentThread.getStackTrace();

        for (int i = 0; i < stackTraceElements.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElements[i];
            // <generated> 标明是当前被代理的class
            if (stackTraceElement.getFileName().equals("<generated>")
                    && stackTraceElement.getClassName().startsWith(curentName)
                    && i < stackTraceElements.length - 1) {
                //CGLIB proxy, classname like this:
                //com.qianmi.statistic.api.controller.login.LoginController$$EnhancerBySpringCGLIB$$9d2b3113
                stackTraceElement = stackTraceElements[i + 1];
                ivk.setParentClassName(stackTraceElement.getClassName().split("\\$\\$")[0]);
                ivk.setParentMethodName(stackTraceElement.getMethodName());

                log.debug("获取线程栈上级,调用类:{},方法:{}", ivk.getParentClassName(), ivk.getParentMethodName());
            }
        }

        return ivk;
    }

}
