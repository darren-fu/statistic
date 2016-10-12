package df.open.statistic.pojo;

import df.open.statistic.util.enumeration.TypeEnum;
import df.open.statistic.util.enumeration.ResultEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

import static com.alibaba.fastjson.JSON.toJSONString;

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
@Data
public class Invoker {


    private TypeEnum type;

    private ResultEnum result;

    /**
     * 当前方法
     */
    private String methodName;

    /**
     * 当前class
     */
    private String className;

    /**
     * 上级class
     */
    private String parentClassName;

    /**
     * 上级方法
     */
    private String parentMethodName;

    /**
     * 耗时
     */
    private Long cost;

    /**
     * 调用此次数
     */
    private Integer count;

    /**
     * 调用时间
     */
    private Date invokeTime;


    public void increaseCost(Long cost) {
        this.cost += cost;
    }

    public void increaseCount(Integer count) {
        this.count += count;
    }


    /**
     * 根据class信息，生成key，排除cost等信息
     *
     * @return
     */
    public String getKey() {
        StringBuffer sb = new StringBuffer();
        String dot = ".";
        String pound = "#";
        sb.append(this.getClassName())
                .append(dot)
                .append(this.getMethodName());
        if (StringUtils.isNotEmpty(this.getParentClassName())) {
            sb.append(pound)
                    .append(this.getParentClassName())
                    .append(this.getParentMethodName());
        }

        return sb.toString();
    }
}
