package org.kb4md.TFinfo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb4md.TFinfo.config.TFinfoConfig;
import org.kb4md.TFinfo.service.TFinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by DC on 2018/06/09
 */
//@Runwith运行器
//@RunWith(JUnit4.class)就是指用JUnit4来运行   @RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境   @RunWith(Suite.class)的话就是一套测试集合
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合Junit4测试时，使用@ContextConfiguration注解引入配置文件
@ContextConfiguration(classes = TFinfoConfig.class)
@PropertySource(value = "classpath:application.properties")
public class AppTest {

    @Autowired
    private TFinfoService tfinfoService;

    @Test
    public void test1() throws Exception{
        System.out.println(tfinfoService.getPromoteridRecommend("samd"));
    }

    @Test
    public void test2() throws Exception{
        System.out.println(tfinfoService.getPromoterByPromoterid("SAMD11_1"));
    }

    @Test
    public void test3() throws Exception{
        System.out.println(tfinfoService.getTFsByPromoterid("SAMD11_1"));
    }

}
