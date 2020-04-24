package com.device.monitor.service;

import com.device.monitor.core.caller.ICallback;
import com.device.monitor.model.DeviceInfo;

public interface MonitorService {
	
	public Object deviceLogin(DeviceInfo deviceInfo);
	
	public Object deviceLogin(DeviceInfo deviceInfo, ICallback callback);
}
