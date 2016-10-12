package df.open.statistic.core.dao;

import df.open.statistic.pojo.InvokerDB;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
 * @date 2016/8/20
 */
public interface InvokerMapper extends BaseMapper<InvokerDB>{

    int insertBatch(List<InvokerDB> list);

    List<InvokerDB> listByProjectAndType(@Param("project") String project, @Param("type") String type);
}
