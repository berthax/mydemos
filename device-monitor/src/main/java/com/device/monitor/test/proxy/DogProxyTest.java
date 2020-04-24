package com.device.monitor.test.proxy;

public class DogProxyTest {
	
	public static void main(String[] args) {
		Dog proxy = DogEnhancer.createDogProxy(Dog.class, new DogMethodInterceptor());
		proxy.eat();
	}
}
