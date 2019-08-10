package com.example.demo.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.experimental.Accessors;
@Component
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "test.one")
public class TestOneConfig {
	private static final long serialVersionUID = 1L;

	private int first;
	private int  second;
}
