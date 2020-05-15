package com.luoyan.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author michael
 */
@Component
public class MoonBeanPostprocessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("person".equals(beanName)) {
            System.out.println("------"+ bean+ " postProcessBeforeInitialization--------");
            Person p = (Person) bean;
            p.setName("nono");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("person".equals(beanName)) {
            System.out.println("------"+ bean+" postProcessAfterInitialization--------");
        }
        return bean;
    }
}
