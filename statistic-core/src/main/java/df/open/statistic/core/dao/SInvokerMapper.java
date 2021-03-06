package df.open.statistic.core.dao;

import df.open.statistic.core.model.SInvoker;
import df.open.statistic.core.model.SInvokerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SInvokerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_invoker
     *
     * @mbggenerated
     */
    int countByExample(SInvokerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_invoker
     *
     * @mbggenerated
     */
    int deleteByExample(SInvokerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_invoker
     *
     * @mbggenerated
     */
    int insert(SInvoker record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_invoker
     *
     * @mbggenerated
     */
    int insertSelective(SInvoker record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_invoker
     *
     * @mbggenerated
     */
    List<SInvoker> selectByExample(SInvokerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_invoker
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SInvoker record, @Param("example") SInvokerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_invoker
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SInvoker record, @Param("example") SInvokerExample example);
}