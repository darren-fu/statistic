package df.open.statistic.extend.spring4.config;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

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
public class StatisticAopCondition extends AbstractStatisticCondition {
    private String key = "statistic.enable";

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return isConfigEnabled(context, key);
    }
}
