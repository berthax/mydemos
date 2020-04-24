package com.device.monitor.core.callback;

public interface StdCallbackInvoker {
	void invoke(Object... params);
	
	//该方法是否需要参数需要定义
	boolean support(Class<?> clazz,Object... params);
	
}
