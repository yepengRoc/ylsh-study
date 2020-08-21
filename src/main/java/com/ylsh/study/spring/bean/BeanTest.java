package com.ylsh.study.spring.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

public class BeanTest {
    
    @Test
    public void testBean() throws  Exception{
       BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
       MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");



        DefaultListableBeanFactory df = new DefaultListableBeanFactory(null);
        XmlBeanDefinitionReader xr = new XmlBeanDefinitionReader(df);
        xr.loadBeanDefinitions(new ClassPathResource("spring-config.xml"));

        df.getBean("");

        Map<Thread, StackTraceElement[]> ts = Thread.getAllStackTraces();
       /* StackTraceElement[] ste = ts.get(Thread.currentThread());
        for (StackTraceElement s : ste) {
            System.out.println(s.toString());
//            Log.d("Info ", s.toString());
        }
        new Exception("print trace").printStackTrace();*/
       System.out.println(myTestBean.getMyTestStr());
    }

}
