package org.kb4md.TFinfo.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * created by DC on 2018/06/08
 */
@Configuration
@ComponentScan(basePackages = {"org.kb4md.TFinfo"})
@PropertySource(value = "classpath:application.properties")
@Import(value = {TFinfoMybatisConfig.class})
public class TFinfoConfig {
}
