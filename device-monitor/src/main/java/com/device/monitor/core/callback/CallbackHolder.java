package com.device.monitor.core.callback;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.jna.win32.StdCallLibrary.StdCallCallback;
/**
 * 
 * <p>[功能描述]：布防回调函数的全局持有者，
 * 以免长时间不操作的时候，被gc回收，影响回调处理</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月23日
 * @since	Troila bertha
 *
 */
public class CallbackHolder {
	public static final Map<String,StdCallCallback> callbackHolderMap = new ConcurrentHashMap<>();
	
	public static void regist(String deviceIp,StdCallCallback callback) {
		callbackHolderMap.put(deviceIp, callback);
	}
	
	public static void unregist(String deviceIp) {
		if(Objects.nonNull(callbackHolderMap.get(deviceIp))) {
			callbackHolderMap.remove(deviceIp);			
		}
	}
}
