package com.luoyan.springboot;

import com.luoyan.springboot.mapper.OrderMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.luoyan.springboot")
public class LuoyanApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(LuoyanApplication.class, args);

        OrderMapper orderMapper = applicationContext.getBean(OrderMapper.class);

        long select = orderMapper.select(1L);
        System.out.println("result : " + select);
    }

}
