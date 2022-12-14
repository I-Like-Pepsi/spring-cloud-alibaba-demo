package com.zc.config;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

/**
 *
 * @author zengchao
 * @date 2022-12-14 14:52:50
 */
//@LoadBalancerClient(name = "nacos-register", configuration = RandomLoadBalancerRuleConfig.class)
@LoadBalancerClient(name = "nacos-register", configuration = WeightLoadBalancerRuleConfig.class)
public class LoadBalancerConfig {

}
