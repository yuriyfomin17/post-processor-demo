package com.nimofy.postprocessordemo;

import com.nimofy.postprocessordemo.annotations.Trimmed;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (this.requiresProxying(bean.getClass())) {
            return createProxy(bean);

        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private Object createProxy(Object beanInstance) {
        var enhancer = new Enhancer();
        enhancer.setSuperclass(beanInstance.getClass());
        enhancer.setInterfaces(beanInstance.getClass().getInterfaces());
        MethodInterceptor methodInterceptor = (obj, method, args, proxy) ->{
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i].isAnnotationPresent(Trimmed.class)){
                    args[i] = ((String) args[i]).trim();
                }
            }
            return proxy.invokeSuper(obj, args);

        };
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();

    }

    private boolean requiresProxying(Class<?> beanClass) {
        for (Method method : beanClass.getDeclaredMethods()) {
            for (Parameter parameter : method.getParameters()) {
                if (parameter.isAnnotationPresent(Trimmed.class)) return true;
            }
        }
        return false;
    }
}
