package com.device.monitor.test.caller;

public class Caller {
	
	private ICallback callback;

	public void setCallback(ICallback callback) {
		this.callback = callback;
	}
	
	public void doCallback() {
		callback.func();
	}

}
