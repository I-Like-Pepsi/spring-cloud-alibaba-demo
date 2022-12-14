package com.zc.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *
 * @author zengchao
 * @date 2022-12-14 11:44:22
 */
@RestController
public class LoadBalancerController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("loadbalancer")
    public String loadbalancer(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://nacos-register/hello", String.class);
        return response.getBody();
    }

}
