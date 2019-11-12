package com.example.springboot.entity;

import java.io.Serializable;

//这里是javaBean，实现序列化
public class Student implements Serializable {
    private static final long serialVersionUID = 1l;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
