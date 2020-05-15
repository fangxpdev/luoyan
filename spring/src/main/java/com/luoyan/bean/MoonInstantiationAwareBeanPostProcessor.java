package com.luoyan.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author michael
 */
@Component
public class MoonInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("person".equals(beanName)) {
            System.out.println("<---"+beanName+" postProcessBeforeInstantiation--->");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("person".equals(beanName)) {
            System.out.println("<---"+beanName+" postProcessAfterInstantiation--->");
        }
        return true;
    }
}
