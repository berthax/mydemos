package com.device.monitor.core.callback.proxy;

import com.device.monitor.core.callback.filter.FilterChain;

public class CallbackChainInterceptor implements CallbackInterceptor{

	private FilterChain chain;
	
	public CallbackChainInterceptor(FilterChain chain) {
		super();
		this.chain = chain;
	}

	@Override
	public void doBefore(Object obj) {
		
	}

	@Override
	public void doAfter(Object obj) {
		//执行过滤连
		if(chain!=null) {					
			chain.doFilter(obj);
		}
	}

}
