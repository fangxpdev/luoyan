package com.luoyan.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 6856397785713828603L;
    // 学号
    private Integer id;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 班级
    private String className;


}
