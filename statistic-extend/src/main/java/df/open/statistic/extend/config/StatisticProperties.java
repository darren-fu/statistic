package df.open.statistic.extend.config;

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
 * @date 2016/8/4
 */
public class StatisticProperties {

    private Boolean enable = true;

    private String project;

    private String url;

    /**
     * 性能统计基线 ms,超过的单独统计，低于基线归纳统计
     */
    private int baseline = 10;

    /**
     * 记录队列size
     */
    private int RecordQeueuSize = 100;

    /**
     * 单次从队列中批量获取的数量
     */
    private int RecordQeueuTakeSize = 5;

    /**
     * 数据处理/发送，核心线程池
     */
    private int CoreThreadNum = 3;

    /**
     * 数据处理/发送，最大线程数
     */
    private int MaxThreadNum = 5;

    public int getBaseline() {
        return baseline;
    }

    public void setBaseline(int baseline) {
        this.baseline = baseline;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRecordQeueuSize() {
        return this.RecordQeueuSize;
    }

    public void setRecordQeueuSize(int recordQeueuSize) {
        RecordQeueuSize = recordQeueuSize;
    }

    public int getRecordQeueuTakeSize() {
        return this.RecordQeueuTakeSize;
    }

    public void setRecordQeueuTakeSize(int recordQeueuTakeSize) {
        RecordQeueuTakeSize = recordQeueuTakeSize;
    }

    public int getCoreThreadNum() {
        return CoreThreadNum;
    }

    public void setCoreThreadNum(int coreThreadNum) {
        CoreThreadNum = coreThreadNum;
    }

    public int getMaxThreadNum() {
        return MaxThreadNum;
    }

    public void setMaxThreadNum(int maxThreadNum) {
        MaxThreadNum = maxThreadNum;
    }


}
