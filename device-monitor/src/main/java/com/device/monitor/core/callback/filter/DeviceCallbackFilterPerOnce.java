package com.device.monitor.core.callback.filter;

public abstract class DeviceCallbackFilterPerOnce implements DeviceCallbackFilter {
	
	private int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
