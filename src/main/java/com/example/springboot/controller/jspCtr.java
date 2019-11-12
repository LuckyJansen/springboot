package com.example.springboot.controller;

import com.example.springboot.entity.Hive;
import com.example.springboot.entity.Student;
import com.example.springboot.mapper.HiveMapper;
import com.example.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class jspCtr {


    @Resource
    HiveMapper hiveMapper;

    @Resource
    StudentMapper studentMapper;

    @RequestMapping("/hello")
    String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));

        List<Student> students =studentMapper.findAll();
        m.addAttribute("students", students);
        return "hello"; //这里会返回给hello.jsp文件中
    }








}
