package com.zc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 *
 * @author zengchao
 * @date 2022-12-13 11:10:06
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
    private String classNo;
    private String className;
    private String extPro;
}
