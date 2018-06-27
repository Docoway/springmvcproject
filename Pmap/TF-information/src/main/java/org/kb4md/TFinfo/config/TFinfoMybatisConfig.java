package org.kb4md.TFinfo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * created by DC on 2018/06/08
 */
//@Configuration用于定义配置类，可替换xml文件 类中的方法用于构建bean定义
@Configuration(value = "TFinfoMybatisConfig")
//@Mapperscan 指定要扫描的mapper类包的路径
@MapperScan(basePackages = "org.kb4md.TFinfo.mapper", sqlSessionFactoryRef = "TFinfoSessionFactory")
@ComponentScan(value = {"org.kb4md.TFinfo"})
//开启AOP
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource(value = "classpath: application.properties")
@EnableTransactionManagement
public class TFinfoMybatisConfig {

    public static final Logger logger = LoggerFactory.getLogger(TFinfoMybatisConfig.class);

    @Autowired
    private Environment environment;

    @Bean(name = "TFinfoSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(TFinfoDataSource());
        sessionFactory.setTypeAliasesPackage("org.kb4md.TFinfo.data");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath: org/kb4md/TFinfo/mapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean(name = "TFinfoDataSource")
    public DruidDataSource TFinfoDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getProperty("dataSource.driverClass"));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.username"));
        dataSource.setPassword(environment.getProperty("dataSource.password"));

        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMinIdle(2);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(5);
        return dataSource;
    }

    @Bean(name = "TFinfoManager")
    public DataSourceTransactionManager TFinfoManager(){
        return new DataSourceTransactionManager(TFinfoDataSource());
    }
}
