package com.device.monitor.core.callback.filter.impl;

import com.device.monitor.core.callback.filter.DeviceCallbackFilterPerOnce;
import com.device.monitor.core.callback.filter.FilterChain;

//@Component
public class TestDviceCallbackFilter2 extends DeviceCallbackFilterPerOnce {

	
	//设置过滤连优先级，越小优先级越大
	@Override
	public int getOrder() {
		return 2;
	}

	@Override
	public void doFilter(Object obj, FilterChain filterChain) {
//		System.out.println("filter2 --" + obj);
		filterChain.doFilter(obj);
	}

}
