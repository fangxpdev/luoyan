package com.luoyan.startup;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * 内嵌tomcat启动
 * java config 配置
 * 模拟springboot启动
 */
public class ApplicationStartup {

    public static void main(String[] args) throws LifecycleException {


        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);

        tomcat.addWebapp("/", "/Users/michael/data/tomcat/");
        tomcat.start();
        tomcat.getServer().await();


    }

}
