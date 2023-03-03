package com.nimofy.postprocessordemo;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

public class TrimmedBeanConfiguration {

    @Bean
    public BeanPostProcessor getBeanPostProcessor(){
        return new TrimmedAnnotationBeanPostProcessor();
    }
}
