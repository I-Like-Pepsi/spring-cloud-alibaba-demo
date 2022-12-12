package com.zc.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.security.SecureRandom;
import java.util.List;

/**
 *
 * @author zengchao
 * @date 2022-12-12 16:48:30
 */
@RestController
public class DiscoveryController {
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private RestTemplate restTemplate;
    private SecureRandom random = new SecureRandom();

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("say_hello")
    public Object sayHello(){
        //获取服务实例列表
        String serviceId = "nacos-register";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if (instances.size() == 0){
            throw new RuntimeException(String.format("没有可用的服务[%s]",serviceId));
        }
        //随机选取一个服务实例
        int index = random.nextInt(instances.size());
        ServiceInstance instance = instances.get(index);
        //调用服务
        String url = String.format("http://%s:%s/hello", instance.getHost(), instance.getPort());
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

}
