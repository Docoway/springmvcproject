package org.kb4md.disease.view.config;


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
 * created by DC on 2018/06/25
 */
@Configuration(value="DiseaseViewMybatisConfig")
@MapperScan(basePackages = "org.kb4md.disease.view.mapper", sqlSessionFactoryRef = "diseaseViewSessionFactory")
@ComponentScan(value = {"org.kb4md.disease.view"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@PropertySource(value = "classpath: application.properties")
public class DiseaseViewMybatisConfig {

    private static final Logger logger = LoggerFactory.getLogger(DiseaseViewMybatisConfig.class);

    @Autowired
    private Environment env;

    @Bean(name = "diseaseViewSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(diseaseViewDataSource());
        sessionFactory.setTypeAliasesPackage("org.kb4md.disease.view.data");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources("classpath: org/kb4md/disease/view/mapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean(name = "diseaseViewDataSource")
    public DruidDataSource diseaseViewDataSource(){
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(env.getProperty("dataSource.driverClass"));

        dataSource.setUrl(env.getProperty("dataSource.url"));
        dataSource.setUsername(env.getProperty("dataSource.username"));
        dataSource.setPassword(env.getProperty("dataSource.password"));

        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMinIdle(2);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(5);

        return dataSource;
    }

    @Bean(name = "diseaseViewTxManaget")
    public DataSourceTransactionManager diseaseViewTxManager(){
        return new DataSourceTransactionManager(diseaseViewDataSource());
    }
}
