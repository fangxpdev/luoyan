package com.luoyan.mapper;

import com.luoyan.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testSelect() {

        Product product = productMapper.selectById(1);
        System.out.println(product);
    }


    @Test
    public void testInsert() {
        Product product = new Product();
        product.setUserId(2L);
        product.setPrice(new BigDecimal("2.22"));
        product.setStatus(0);
        Integer res = productMapper.insert(product);
        System.out.println(res);
    }

}
