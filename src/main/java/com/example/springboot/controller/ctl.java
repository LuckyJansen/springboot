package com.example.springboot.controller;

import com.example.springboot.entity.Hive;
import com.example.springboot.mapper.HiveMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ctl {


    private static final Log log = LogFactory.getLog(ctl.class); //记录日志




    @Value("${content}")
    String content;

    @RequestMapping("/index")
    String index() {
        if(log.isTraceEnabled()){
            log.trace("这是trace的日志");
        }
        log.trace("这是trace的另一条日志");
        return "Hello Spring Boot"+content;
    }

    //实现了上传文件，我好牛逼。
    //通过在hello.jsp文件中的form表单，提交文件到upload，实现了上传并保存文件到服务器
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestParam("file") MultipartFile imgFile) throws Exception {

        if(log.isTraceEnabled()){
            log.trace("接收到文件："+imgFile.getOriginalFilename());
        }
        //保存文件
        FileOutputStream fos = new FileOutputStream("src/test/"+imgFile.getOriginalFilename());
        IOUtils.copy(imgFile.getInputStream(), fos);
        fos.close();
    }

    //图片也能读取了，真是太牛逼了
    @GetMapping(value = "/showImage", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getIcon() throws Exception {

        String iconFile = "src/test/test.png";
        InputStream is = new FileInputStream(iconFile);
        return IOUtils.toByteArray(is);
    }


    @Resource
    HiveMapper hiveMapper;

    @RequestMapping("/hive")
    public Object listHive(){
        List<Hive> result = hiveMapper.findAll();
        return result;
    }




}
