package df.open.statistic.core.dao;

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
 * @date 2016/8/23
 */
public interface BaseMapper<T> {

    int insert(T o);
    int update(T o);
    int delete(T o);
    List<T> select(T o);
}
