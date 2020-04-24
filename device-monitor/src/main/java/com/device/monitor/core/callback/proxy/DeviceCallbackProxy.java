package com.device.monitor.core.callback.proxy;

import java.util.List;

import org.springframework.cglib.proxy.Enhancer;

import com.device.monitor.core.callback.StdCallbackInvoker;
import com.device.monitor.core.callback.filter.FilterChain;
import com.device.monitor.model.SingleOperationRes;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;

public class DeviceCallbackProxy {
	
	@SuppressWarnings("unchecked")
	public static <T> T createCallback(Class<? extends StdCallCallback> t,FilterChain chain) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(t);
		//设置过滤链
		enhancer.setCallback(new EnhancerInterceptor(new CallbackChainInterceptor(chain)));
		return (T) enhancer.create();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T createCallback(Class<? extends StdCallCallback> t,FilterChain chain,List<StdCallbackInvoker> invokers,SingleOperationRes singleOperationRes) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(t);
		//设置过滤链
		EnhancerInterceptor enhancerInterceptor = new EnhancerInterceptor(new CallbackChainInterceptor(chain));
		enhancerInterceptor.setInvokers(invokers);
		enhancerInterceptor.setSingleOperationRes(singleOperationRes);
		enhancer.setCallback(enhancerInterceptor);
		return (T) enhancer.create();
	}
	
}
