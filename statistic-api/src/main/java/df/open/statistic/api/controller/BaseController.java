package df.open.statistic.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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
 * @date 2016/8/13
 */
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public Map<String, Object> success() {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "ok");
        result.put("data", "");
        result.put("msg", "操作成功");
        return result;
    }

    public Map<String, Object> success(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "ok");
        result.put("data", data);
        result.put("msg", "操作成功");
        return result;
    }

    public Map<String, Object> success(Object data, String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "ok");
        result.put("data", data);
        result.put("msg", msg);
        return result;
    }

    /**
     * 失败返回的json数据
     *
     * @return
     */
    protected Map<String, Object> fail() {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "fail");
        result.put("msg", "操作失败");
        return result;
    }

    /**
     * 失败返回的json数据
     *
     * @return
     */
    protected Map<String, Object> fail(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "fail");
        result.put("data", data);
        result.put("msg", "操作失败");
        return result;
    }

    /**
     * 失败返回的json数据
     *
     * @return
     */
    protected Map<String, Object> fail(Object data, String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("result", "fail");
        result.put("data", data);
        result.put("msg", msg);
        return result;
    }


}
