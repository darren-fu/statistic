package df.open.statistic.extend.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

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
 * @date 2016/7/21
 */
public class ClassHelper {
    private static Logger log = LoggerFactory.getLogger(ClassHelper.class);

    /**
     * 获取class中由ioc容器注入的对象
     *
     * @param clz
     */
    public static void getInjectedClz(Class clz) {

        Set<Class> injectClzSet = new HashSet<Class>();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            if (isInjectedField(field)) {
                Class injectClz = field.getType();
                System.out.println(injectClz);
                injectClzSet.add(injectClz);
            }
        }
        log.debug("在类[{}]中发现IOC容器管理的对象{}个.{}", clz.getSimpleName(), injectClzSet.size(), classToString(injectClzSet));
    }


    /**
     * 判断类变量是否是ioc容器注入的对象
     *
     * @param field
     * @return
     */
    public static boolean isInjectedField(Field field) {
        if (field.getAnnotation(Resource.class) != null) {
            return true;
        }
        //避免依赖spring的库
        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().getName().equals("org.springframework.beans.factory.annotation.Autowired")) {
                return true;
            }
        }
        return false;
    }


    /**
     * class set's className to string
     *
     * @param clzs
     * @return
     */
    private static String classToString(Set<Class> clzs) {
        if (clzs == null || clzs.size() < 1) {
            return null;
        }
        return classToString((Class[]) clzs.toArray());
    }

    /**
     * class array' className to string
     *
     * @param clzs
     * @return
     */
    private static String classToString(Class[] clzs) {
        StringBuilder sb = new StringBuilder();
        for (Class clz : clzs) {
            sb.append(clz.getName());
        }
        return sb.toString();
    }


    public static void main(String[] args) {

    }


}
