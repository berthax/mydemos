package com.device.monitor.core.operation.impl;

import org.springframework.stereotype.Component;

import com.device.monitor.core.operation.AbstractOperation;

@Component
public class MessagePushOperation extends AbstractOperation{

	@Override
	public void operate(Object object) {
		System.out.println("此处进行处理结果消息推送操作，操作结果为:" + object);
	}

	@Override
	public boolean support() {
		return true;
	}

}
