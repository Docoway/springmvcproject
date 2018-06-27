package org.kb4md.rest.config.AppConfig;


import org.kb4md.rest.config.SecurityConfig.SecurityConfig;
import org.kb4md.rest.utils.UTF8StringHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@EnableWebMvc
@ComponentScan("org.kb4md.rest")
@Import(value={SecurityConfig.class})
@PropertySource(value="classpath: application.properties")
@Configuration
public class WebContextConfigs extends WebMvcConfigurerAdapter {

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(utf8HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    private HttpMessageConverter<String> utf8HttpMessageConverter(){
        return new UTF8StringHttpMessageConverter();
    }
}
