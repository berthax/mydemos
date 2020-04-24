package com.device.monitor.core.callback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.device.monitor.core.callback.filter.FilterChain;
import com.device.monitor.core.callback.proxy.DeviceCallbackProxy;
import com.device.monitor.model.SingleOperationRes;
import com.sun.jna.win32.StdCallLibrary.StdCallCallback;
/**
 * 
 * <p>[功能描述]:设备回调函数的工厂类</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月23日
 * @since	Troila bertha
 *
 */
//@Component
public class FRemoteCfgCallbackFactory {
	
	@Autowired
	private List<StdCallbackInvoker> callbackInvokers;
	
	@Autowired
	private FilterChain chain;
		
	public <T extends StdCallCallback> T getCallback(Class<T> clazz,SingleOperationRes singleOperationRes) {
		T instance = DeviceCallbackProxy.createCallback(clazz, chain, callbackInvokers,singleOperationRes);
		return instance;
	}

}
