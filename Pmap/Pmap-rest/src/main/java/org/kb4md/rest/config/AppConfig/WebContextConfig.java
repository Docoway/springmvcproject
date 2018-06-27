package org.kb4md.rest.config.AppConfig;


import ch.qos.logback.classic.pattern.DateConverter;
import org.kb4md.TFinfo.config.TFinfoConfig;
import org.kb4md.rest.mycat.MyWebSocketHandler;
import org.kb4md.rest.utils.UTF8StringHttpMessageConverter;
import org.springframework.context.annotation.*;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.List;

//开启Spring mvc的配置支持
@EnableWebMvc
@EnableWebSocket
@ComponentScan("org.kb4md.rest")
//@Import 引入指定的配置类
@Import(value={TFinfoConfig.class})
@PropertySource(value = "classpath: application.properties")
@Configuration
public class WebContextConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    /**
     * configureMessageConverter重写替换所有默认的MessageConverter，使用自定义的converters
     * extendMessageConverter是在原有默认的基础上添加自定义的converters实例
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){

        converters.add(utf8HttpMessageConverter());
        converters.add(new StringHttpMessageConverter());//支持返回类型为String

        //json数据转换(默认的)
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        converters.add(jsonConverter);
    }

    private HttpMessageConverter<String> utf8HttpMessageConverter(){
        return new UTF8StringHttpMessageConverter();
    }


    /**
     * 实现WebSocketConfigure接口，重写registerWebSocketHandlers方法，这是一个核心实现方法，配置websocket入口，允许访问的域，注册handler和拦截器
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        registry.addHandler(myWebSocketHandler(),"/myHandler")    //收集和任务分发中心
                .addInterceptors(new HttpSessionHandshakeInterceptor())  //为handler添加拦截器，可以在你调用handler之后调用自己的逻辑代码
                .setAllowedOrigins("*");  //允许指定的域名或IP建立连接，不限时使用"*"号，如果指定域名，则必须以http或https开头
    }

    @Bean
    public WebSocketHandler myWebSocketHandler(){
        return new MyWebSocketHandler();
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer(){
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }

    /**
     * Spring中Converter 和Formatter都是用来做数据转换的，Converter可以从任意类型转换为任意类型，而Formatter则是从String类型转换为任务目标类型
     */
    /*
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new DateConverter());
    }
    */
}
