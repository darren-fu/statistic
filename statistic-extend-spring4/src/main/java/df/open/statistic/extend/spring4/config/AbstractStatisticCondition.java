package df.open.statistic.extend.spring4.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

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
public abstract class AbstractStatisticCondition implements Condition {



    public boolean isConfigEnabled(ConditionContext context, String key) {
        if (context == null || StringUtils.isEmpty(key)) {
            return false;
        }
        boolean isAspectTypeEnabled = false;

        String configType = context.getEnvironment().getProperty(key);

        if (!StringUtils.isEmpty(configType)) {
            isAspectTypeEnabled = "TRUE".equals(configType.toUpperCase());
        }

        return isAspectTypeEnabled;
    }

    public abstract boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
}
