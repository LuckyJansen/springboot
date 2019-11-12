package com.example.springboot.mapper;

import com.example.springboot.entity.Hive;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HiveMapper {

    @Select("select * from hive")
    List<Hive> findAll();
}
