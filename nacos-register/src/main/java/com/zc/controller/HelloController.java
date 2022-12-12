package com.zc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zengchao
 * @date 2022-12-12 16:36:44
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("hello")
    public Object hello(){
        return "Hello World! " + serverPort;
    }

}
