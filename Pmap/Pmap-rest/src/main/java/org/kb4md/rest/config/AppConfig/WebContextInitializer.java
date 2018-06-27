package org.kb4md.rest.config.AppConfig;

import com.alibaba.druid.support.http.StatViewServlet;
import com.thetransactioncompany.cors.CORSFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;


//实现WebApplicationInitializer接口，是项目的入口，作用类似于web.xml
public class WebContextInitializer implements WebApplicationInitializer {

    private static final long MAX_FILE_SIZE = 5242880;//5MB Max file size

    private static final long MAX_REQUEST_SIZE = 20971520;// 20MB  Total request size containing multi part.

    private static final int FILE_SIZE_THRESHOLE = 0; //Size threshold after which files will be written to disk


    @Override
    public void onStartup(ServletContext container) throws ServletException{

        /**
         * create spring application context, this class will look for spring configuration in classes annotated with @Configuration
         */
        //实例化一个web application context
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebContextConfig.class);

        /**
         * glue WebApplicationContext to lifecycle of container
         */
        //注册监听器和过滤器
        container.addListener(new ContextLoaderListener(webContext));
        //container.addFilter("springSecurityFilterChain",new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null,false,"/*");

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",new DispatcherServlet(webContext));
        dispatcher.setMultipartConfig(this.getMultipartConfigElement());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        ServletRegistration.Dynamic druidMonitor = container.addServlet("druidMonitor",new StatViewServlet());
        druidMonitor.addMapping("/druidMonitor/*");
        druidMonitor.setInitParameter("loginUsername","admin");
        druidMonitor.setInitParameter("loginUsername","lmy86263");


        FilterRegistration.Dynamic crossOrigin = container.addFilter("crossOrigin", CORSFilter.class);
        crossOrigin.addMappingForUrlPatterns(null,false,"/*");
        crossOrigin.setInitParameter("cros.allowOrigin","*");
        crossOrigin.setInitParameter("cros.supportedMethods","GET,POST,HEAD,PUT,DELETE");
        crossOrigin.setAsyncSupported(true);


    }

    //文件上传
    private MultipartConfigElement getMultipartConfigElement(){
        MultipartConfigElement element = new MultipartConfigElement(null,MAX_FILE_SIZE,MAX_REQUEST_SIZE,FILE_SIZE_THRESHOLE);
        return element;
    }
}
