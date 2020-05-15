package com.luoyan.springboot.mapper;

import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    @Select("select status from product where id = #{id}")
    int select(Long id);

}
