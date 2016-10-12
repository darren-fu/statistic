package df.open.statistic.api.controller.record;

import com.alibaba.fastjson.JSON;
import df.open.statistic.api.controller.BaseController;
import df.open.statistic.core.service.RecordService;
import df.open.statistic.pojo.InvokerDB;
import df.open.statistic.util.common.ZipUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static df.open.statistic.util.common.ZipUtil.gunzip;

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
@RestController
@RequestMapping(value = "/api/record", method = RequestMethod.POST)
public class RecordController extends BaseController {

    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/performance", method = RequestMethod.POST)
    public Map<String, Object> record(String project, String token, String data) {

        log.error("project:{}", project);
        log.error("data.length:{},data:{}", data.length(), gunzip(data));

        String invokersData = ZipUtil.gunzip(data);

        List<InvokerDB> invokers = JSON.parseArray(invokersData, InvokerDB.class);

//        recordService.recordInvokers(project,invokers);
        return success();
    }

    @RequestMapping(value = "/exception")
    public Map<String, Object> recordException(String project, String token, String data) {


        return success();
    }


}
