package df.open.statistic.util.enumeration;

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
public enum ResultEnum {
    SUCCESS(1),

    FAIL(0);

    private int value;

    ResultEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    public String getName() {
        switch (this.value) {
            case 0:
                return "FAIL";
            case 1:
                return "SUCCESS";
            default:
                return null;
        }
    }

    /**
     * 根据值返回枚举
     *
     * @param value
     * @return
     */
    public static ResultEnum getEnum(int value) {
        switch (value) {
            case 0:
                return FAIL;
            case 1:
                return SUCCESS;

            default:
                return null;
        }
    }
}
