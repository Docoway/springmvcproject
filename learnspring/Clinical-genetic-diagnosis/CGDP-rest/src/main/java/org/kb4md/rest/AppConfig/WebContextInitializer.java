package org.kb4md.rest.AppConfig;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * created by DC on 2018/06/26
 */
public class WebContextInitializer implements WebApplicationInitializer{

    public void onStartup(ServletContext container) throws ServletException{
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebContextConfig.class);

        container.addListener(new ContextLoaderListener(webContext));

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",new DispatcherServlet(webContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }
}
