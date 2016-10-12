package df.open.statistic.api.controller;

import df.open.statistic.core.service.RecordService;
import df.open.statistic.pojo.InvokerDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
 * @date 2016/8/20
 */
@RestController
@RequestMapping(value = "/query")
public class QueryController extends BaseController {

    @Autowired
    private RecordService invokerService;

    @RequestMapping(value = "/data/{project}")
    public Map<String, Object> listByProject() {
        List<InvokerDB> list = invokerService.listByProject("test");
        return success(list);
    }
}
