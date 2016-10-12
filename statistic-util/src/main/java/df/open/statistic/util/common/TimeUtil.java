package df.open.statistic.util.common;

import java.math.BigDecimal;

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
 * @date 2016/7/28
 */
public class TimeUtil {

    /**
     * 纳秒转毫秒
     *
     * @param nanoTime
     * @return
     */
    public static long transNanoToMillSeconds(long nanoTime) {
        BigDecimal b = BigDecimal.valueOf(nanoTime * 0.000001);
        System.out.println(nanoTime * 0.000001+ "------" + nanoTime);

        return b.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }

    public static void main(String[] args) {
        long nano = 28990L;
        System.out.println(nano * 0.000001);
        System.out.println(String.valueOf(TimeUtil.transNanoToMillSeconds(nano)));

    }

}
