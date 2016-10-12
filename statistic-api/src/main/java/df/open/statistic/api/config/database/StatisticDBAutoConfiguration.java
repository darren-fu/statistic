package df.open.statistic.api.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Configuration
//@AutoConfigureAfter({DataSourcePoolConfig.class})
@EnableConfigurationProperties(DataSourcePoolConfig.class)
@MapperScan(basePackages = "df.open.statistic.core.dao", sqlSessionTemplateRef = "statisticSqlSessionTemplate")
@EnableTransactionManagement
public class StatisticDBAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(StatisticDBAutoConfiguration.class);

    @Autowired
    private DataSourcePoolConfig dataSourcePoolConfig;

    @Bean(destroyMethod = "close", name = "statisticDataSource")
    @Primary
    public DataSource dataSource() {

        log.error("初始化数据源：{}", dataSourcePoolConfig);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourcePoolConfig.getDriverClassName());
        dataSource.setUrl(dataSourcePoolConfig.getUrl());
        dataSource.setUsername(dataSourcePoolConfig.getUsername());
        dataSource.setPassword(dataSourcePoolConfig.getPassword());
        dataSource.setMaxActive(StringUtils.isNotEmpty(dataSourcePoolConfig.getMaxActive()) ? Integer.valueOf(dataSourcePoolConfig.getMaxActive()) : 20);
        dataSource.setInitialSize(StringUtils.isNotEmpty(dataSourcePoolConfig.getInitialSize()) ? Integer.valueOf(dataSourcePoolConfig.getInitialSize()) : 5);
        dataSource.setMinIdle(StringUtils.isNotEmpty(dataSourcePoolConfig.getMinIdle()) ? Integer.valueOf(dataSourcePoolConfig.getMinIdle()) : 1);

        return dataSource;
//        HikariConfig config = new HikariConfig();
    }

    @Bean(name = "statisticSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("statisticDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/qianmi/statistic/core/mapper/**/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "statisticTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("statisticDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "statisticSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("statisticSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
