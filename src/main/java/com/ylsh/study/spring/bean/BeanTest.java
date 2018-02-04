package com.ylsh.study.spring.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanTest {
    
    @Test
    public void testBean(){
       BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
       MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
       System.out.println(myTestBean.getMyTestStr());
    }

}
