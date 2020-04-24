package com.device.monitor.core.callback.proxy;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.device.monitor.core.callback.OperationInfoContextHolder;
import com.device.monitor.core.callback.StdCallbackInvoker;
import com.device.monitor.model.SingleOperationRes;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class EnhancerInterceptor implements MethodInterceptor{
	
	private List<StdCallbackInvoker> invokers;
	
	private CallbackInterceptor interceptor;
	
	private SingleOperationRes singleOperationRes;
	
	public EnhancerInterceptor(CallbackInterceptor interceptor) {
		super();
		this.interceptor = interceptor;
	}
	public void setSingleOperationRes(SingleOperationRes singleOperationRes) {
		this.singleOperationRes = singleOperationRes;
	}

	public EnhancerInterceptor() {
		super();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
		Object result = null;
		if(interceptor != null && method.getName().equals("invoke")) {
			// 业务中需要对什么进行过滤。需要重新考量
			interceptor.doBefore(obj);
			//方法代理
			Class<?> clazz = method.getDeclaringClass();
			OperationInfoContextHolder.setSingleOperationRes(singleOperationRes);
			if(log.isDebugEnabled()) {
				log.info("【代理预处理】放入回调线程内部:{}",singleOperationRes);				
			}
			invokerProxy(clazz,params);
			if(!clazz.isInterface()) {//代理接口不需要这一步，执行的话会触发NoSuchMethod异常
				result = proxy.invokeSuper(obj, params);
			}
			// 执行后需要对什么进行过滤。需要重考量
			interceptor.doAfter(result);
			OperationInfoContextHolder.clear();
		}else {
			result = proxy.invokeSuper(obj, params);
		}
		return result;
	}
	
	private void invokerProxy(Class<?> clazz, Object[] params) {
		if(invokers!=null && !invokers.isEmpty()) {
			for(StdCallbackInvoker invoker : invokers) {
				if(invoker.support(clazz, params)) {
					invoker.invoke(params);
				}
			}
		}
	}

	public void setInvokers(List<StdCallbackInvoker> invokers) {
		this.invokers = invokers;
	}

}
