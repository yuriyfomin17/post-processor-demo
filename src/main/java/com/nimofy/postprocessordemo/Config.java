package com.nimofy.postprocessordemo;

import com.nimofy.postprocessordemo.annotations.EnableMagic;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMagic
@ComponentScan(basePackages = "com.nimofy.postprocessordemo")
public class Config {
}
