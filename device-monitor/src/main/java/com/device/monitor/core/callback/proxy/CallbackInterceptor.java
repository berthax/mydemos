package com.device.monitor.core.callback.proxy;

public interface CallbackInterceptor {
	public void doBefore(Object obj);
	public void doAfter(Object obj);
}
