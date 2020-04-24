package com.device.monitor.core.callback;

import com.device.monitor.model.SingleOperationRes;
/**
 * 
 * <p>[功能描述]:线程持有当前设备操作的信息类</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月23日
 * @since	Troila bertha
 *
 */
public class OperationInfoContextHolder {
	
	private static final ThreadLocal<SingleOperationRes> threaLocal = new ThreadLocal<>();
	
	public static SingleOperationRes getSingleOperationRes() {
		return threaLocal.get();
	}

	public static void setSingleOperationRes(SingleOperationRes  singleOperationRes) {
		threaLocal.set(singleOperationRes);
	}
	
	public static void clear() {
		threaLocal.remove();
	}
	
	private static final StatusCodeContainer statusCodeContainer = new StatusCodeContainer();
	
	public static StatusCodeContainer statusCodeContainer() {
		return statusCodeContainer;
	}
	
	public static class StatusCodeContainer{
		
		private final ThreadLocal<Integer> statusCodeThreaLocal = new ThreadLocal<>();
		
		public Integer getStatusCode() {
			return statusCodeThreaLocal.get();
		}
		
		public void setStatusCode(Integer statusCode) {
			statusCodeThreaLocal.set(statusCode);
		}
		public void clear() {
			statusCodeThreaLocal.remove();
		}
	}
}
