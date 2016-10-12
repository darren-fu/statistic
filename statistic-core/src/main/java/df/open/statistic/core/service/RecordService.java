package df.open.statistic.core.service;

import df.open.statistic.core.dao.InvokerMapper;
import df.open.statistic.pojo.InvokerDB;
import df.open.statistic.util.common.DateUtil;
import df.open.statistic.util.common.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
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
@Service
public class RecordService extends BaseService {

    @Autowired
    private InvokerMapper invokerMapper;

    public List<InvokerDB> listByProject(String projectCode) {
        InvokerDB ivk = new InvokerDB();
        ivk.setProject(projectCode);
        return invokerMapper.select(ivk);
    }

    /**
     * 记录
     *
     * @param project
     * @param invokers
     * @return
     */
    public int recordInvokers(String project, List<InvokerDB> invokers) {
        if (CollectionUtils.isEmpty(invokers)) {
            log.warn("记录数据量为0");
            return 0;
        }

        String[] uuids = UUIDUtil.getUUIDs(invokers.size());
        Date now = DateUtil.getDate();
        for (int i = 0; i < invokers.size(); i++) {
            InvokerDB invokerDb = invokers.get(i);
            invokerDb.setId(uuids[i]);
            invokerDb.setProject(project);
            invokerDb.setCreateTime(now);
        }
        invokerMapper.insertBatch(invokers);
        log.debug("新增记录{}条", invokers.size());

        return invokers.size();
    }

}
