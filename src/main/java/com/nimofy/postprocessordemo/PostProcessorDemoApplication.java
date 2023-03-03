package com.nimofy.postprocessordemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PostProcessorDemoApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("com.nimofy.postprocessordemo");
        var service = context.getBean(StringService.class);
        System.out.println(service.processString("    SAY_MY_NAME      "));
    }

}
