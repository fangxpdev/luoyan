package com.luoyan.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


@Component
public class MoonFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new Moon();
    }

    @Override
    public Class<?> getObjectType() {
        return Moon.class;
    }

}
