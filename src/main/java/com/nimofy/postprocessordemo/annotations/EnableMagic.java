package com.nimofy.postprocessordemo.annotations;

import com.nimofy.postprocessordemo.TrimmedAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(TrimmedAnnotationBeanPostProcessor.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableMagic {
}
