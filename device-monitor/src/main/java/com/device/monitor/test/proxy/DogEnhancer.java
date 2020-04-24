package com.device.monitor.test.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class DogEnhancer {
	
	public static Dog createDogProxy(Class<?> clazz, MethodInterceptor methodInterceptor) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		 // 设置回调函数，设置了此项，调用代理方法时会被该类的intercept方法拦截，可在此intercept方法中做一些增强处理以满足需求
		enhancer.setCallback(methodInterceptor);
		return (Dog) enhancer.create();
	}
}
