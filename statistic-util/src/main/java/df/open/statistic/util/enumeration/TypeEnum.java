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
 * @date 2016/7/27
 */
public enum TypeEnum {

    /**
     * CONTROLLER
     */
    CONTROLLER(0),

    /**
     * SERVICE
     */
    SERVICE(1),

    /**
     * DAO
     */
    DAO(2);

    private int value;

    TypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        switch (this.value) {
            case 0:
                return "Controller";
            case 1:
                return "Service";
            case 2:
                return "Dao";
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
    public static TypeEnum getEnum(int value) {
        switch (value) {
            case 0:
                return CONTROLLER;
            case 1:
                return SERVICE;
            case 2:
                return DAO;
            default:
                return null;
        }
    }

    public static void main(String[] args) {


    }
}
