package com.luoyan.controller;

import com.luoyan.entity.Product;
import com.luoyan.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    private ProductMapper productMapper;


    @RequestMapping("/order/{id}")
    @ResponseBody
    public Product getOrder(@PathVariable Long id) {
        Product product = productMapper.selectById(id);
        return product;
    }

}
