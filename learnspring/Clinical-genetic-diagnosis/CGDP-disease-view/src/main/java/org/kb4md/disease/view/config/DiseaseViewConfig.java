package org.kb4md.disease.view.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * created by DC on 2018/06/26
 */
@Configuration
@ComponentScan(value = "org.kb4md.disease.view")
@PropertySource(value = "application.properties")
@Import(value = {org.kb4md.disease.view.config.DiseaseViewMybatisConfig.class})
public class DiseaseViewConfig {
}
