package df.open.statistic.api.controller.login;

import df.open.statistic.api.controller.BaseController;
import df.open.statistic.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

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
@RestController
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public String login(String name, String address) throws InterruptedException {

        log.error("login... {}, {}", name, address);
//        Thread.sleep(3000);
        userService.login("userName1", name);
//        log.error("sleep end...");

        return "login...";
    }


    public static void main(String[] args) {
        Field[] fields = LoginController.class.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
                System.out.println(annotation.annotationType().getSimpleName());
            }
            System.out.println(field.getClass());
            System.out.println(field.getType());
            System.out.println(field.getDeclaringClass());
        }
    }
}
