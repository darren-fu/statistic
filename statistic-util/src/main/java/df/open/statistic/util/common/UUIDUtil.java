package df.open.statistic.util.common;

import java.util.Arrays;
import java.util.UUID;

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
 * @date 2016/8/24
 */
public class UUIDUtil {


    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuidToString(uuid).toString();
    }


    public static String[] getUUIDs(int num) {
        StringBuffer sb = new StringBuffer();
        String sep = "#";
        UUID uuid = null;
        for (int i = 0; i < num; i++) {
            if (i > 0) {
                sb.append(sep);
            }
            uuid = UUID.randomUUID();
            appendUuidString(uuid, sb);
        }
        return sb.toString().split(sep);
    }


    private static String uuidToString(UUID uuid) {
        return appendUuidString(uuid, null).toString();
    }

    private static StringBuffer appendUuidString(UUID uuid, StringBuffer sb) {
        sb = sb == null ? new StringBuffer() : sb;
        return sb.append(digits(uuid.getMostSignificantBits() >> 32, 8))
                .append(digits(uuid.getMostSignificantBits() >> 16, 4))
                .append(digits(uuid.getMostSignificantBits(), 4))
                .append(digits(uuid.getLeastSignificantBits() >> 48, 4))
                .append(digits(uuid.getLeastSignificantBits(), 12));
    }

    /**
     * Returns val represented by the specified number of hex digits.
     */
    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }


    public static void main(String[] args) {
        int num =500;
        long start1 = System.currentTimeMillis();

        String[] strarr = new String[500];
        for (int i = 0; i < 500; i++) {
            UUID uuid = UUID.randomUUID();
            strarr[i] = uuid.toString().replace("-","");
        }
        long end1 = System.currentTimeMillis();
        System.out.println("time:" + (end1 - start1));
        long start2 = System.currentTimeMillis();
        String[] ids = UUIDUtil.getUUIDs(500);
        Arrays.stream(ids).forEach(v-> System.out.println(v + ":" +v.length()));
        long end2 = System.currentTimeMillis();
        System.out.println("other time:" + (end2 - start2));

        System.out.println(strarr[0].length());

    }

}
