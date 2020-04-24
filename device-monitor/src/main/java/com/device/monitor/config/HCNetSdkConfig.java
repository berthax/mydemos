package com.device.monitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.device.monitor.sdk.HCNetSDK;


@Configuration
public class HCNetSdkConfig {
	
	@Bean
	public HCNetSDK getHCNetSdkBean() {
		HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
		// 初始化sdk
		hCNetSDK.NET_DVR_Init();
		hCNetSDK.NET_DVR_SetLogToFile(3, "d/sdklog/", false);
		return hCNetSDK;
	}
	

}
