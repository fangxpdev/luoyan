package com.luoyan.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer status;

    private Long userId;

    private BigDecimal price;

}
