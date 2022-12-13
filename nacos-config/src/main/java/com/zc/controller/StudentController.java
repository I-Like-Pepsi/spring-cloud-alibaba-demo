package com.zc.controller;

import com.zc.config.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author zengchao
 * @date 2022-12-13 10:34:55
 */
@RestController
public class StudentController {

    @Value("${student.name}")
    private String name;

    @GetMapping("student")
    public String student() {
        return String.format("name => [%s]", name);
    }

    @Resource
    private Student student;

    @GetMapping("student_refresh")
    public String studentRefresh(){
        return student.toString();
    }
}
