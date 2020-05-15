package com.luoyan.proxy;

import org.springframework.cglib.proxy.Enhancer;

public class CgLibTest {

    public static void main(String[] args) {

        LogIntercepter logIntercepter = new LogIntercepter();
        Enhancer enhancer = new Enhancer();
        // 设置超类，cglib是通过继承来实现的
        enhancer.setSuperclass(UpdateService.class);
        enhancer.setCallback(logIntercepter);
        // 创建代理类
        UpdateService service = (UpdateService)enhancer.create();

        service.update();

    }

}
