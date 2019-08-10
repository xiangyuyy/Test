package com.example.demo.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
@PropertySource(value = "classpath:/application.properties",encoding = "utf-8")
@Component
@Data
public class ConfigBeanValue {
 
    @Value("${good.sign}")
    private String goodSign;    	
    
    @Value("${showphoto.type}")
    private String showPhotoType;    	
}

