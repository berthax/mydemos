package com.device.monitor.test.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * 注意CgLib的代理在真正调用目标方法时，不是基于反射实现的，而是一种FastClass机制
 * nvokeSuper中，通过FastClass机制调用目标类的方法
 * <p>[功能描述]</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月23日
 * @since	Troila bertha
 *
 */
public class DogMethodInterceptor implements MethodInterceptor{

	/**
	 * 
	 * <p>[功能描述]：当我们去调用方法一的时候，在代理类中会先判断是否实现了方法拦截的接口，没实现的话直接调用目标类的方法；
	 * 在方法拦截器中会对目标类中所有的方法建立索引，其实大概就是将每个方法的引用保存在数组中，我们就可以根据数组的下标直接调用方法，而不是用反射；
	 * 索引建立完成之后，方法拦截器内部就会调用invoke方法（这个方法在生成的FastClass中实现），
	 * 在invoke方法内就是调用CGLIB$方法一$这种方法，也就是调用对应的目标类的方法一</p>
	 * 
	 * @author	宣国静, 2020年4月23日
	 * @since	Troila bertha
	 *
	 * @param obj 代理对象
	 * @param method 表示目标类中的方法
	 * @param args 方法参数
	 * @param methodProxy MethodProxy对象，对代理方法进行拦截的对象，通过SetCallback方法设置的
	 * @return
	 * @throws Throwable
	 */
	
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("这里是代理方法增强");
		Object object  = methodProxy.invokeSuper(obj, args);
		return object;
	}

}
