package df.open.statistic.pojo;

import lombok.Data;

import java.util.Date;

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
 * @date 2016/8/23
 */
@Data
public class InvokerDB extends Invoker {
    private String id;
    /**
     * 项目编码
     */
    private String project;

    private Date createTime;
}
