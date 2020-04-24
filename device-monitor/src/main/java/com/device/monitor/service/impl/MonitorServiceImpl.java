package com.device.monitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.device.monitor.core.caller.ICallback;
import com.device.monitor.model.DeviceInfo;
import com.device.monitor.sdk.HCNetSDK;
import com.device.monitor.sdk.HCNetSDK.NET_DVR_DEVICEINFO_V30;
import com.device.monitor.service.MonitorService;
import com.sun.jna.NativeLong;
@Service
public class MonitorServiceImpl implements MonitorService{

	@Autowired
	private HCNetSDK hCNetSDK;
	
	@Override
	public Object deviceLogin(DeviceInfo deviceInfo) {

		NET_DVR_DEVICEINFO_V30 lpDeviceInfo = new NET_DVR_DEVICEINFO_V30();
		NativeLong luserId = new NativeLong(-1);
		// 返回一个用户句柄编号
		luserId = hCNetSDK.NET_DVR_Login_V30(deviceInfo.getIp(), deviceInfo.getPort(), deviceInfo.getUsername(), deviceInfo.getPassword(), lpDeviceInfo);
		if(luserId.longValue() < 0) {
			System.out.println("登录失败，错误码为：" + hCNetSDK.NET_DVR_GetLastError());
		}else {
			System.out.println("登录成功");
		}
		return luserId;
	}

	@Override
	public Object deviceLogin(DeviceInfo deviceInfo, ICallback callback) {
		Object obj = deviceLogin(deviceInfo);
		callback.setProgress(100);
		callback.setResult(obj);
		return obj;
	}
}
