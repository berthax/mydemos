package com.device.monitor.controller;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.device.monitor.common.exception.ErrorCodeEnum;
import com.device.monitor.common.exception.ServiceException;
import com.device.monitor.core.caller.ICallback;
import com.device.monitor.core.caller.MyCallback;
import com.device.monitor.core.operation.Operation;
import com.device.monitor.model.DeviceInfo;
import com.device.monitor.service.MonitorService;

@RestController
public class MonitorController {
	
	@Autowired
	private Operation operation;
	@Autowired
	private MonitorService monitorService;
	@Autowired
	private RedisTemplate<String, Object> redis;
	
	@PostConstruct
	public void init() {
		System.out.println(operation);
	}
	
	@PostMapping("/deviceLogin")
	public Object loginDemo(@Valid @RequestBody DeviceInfo deviceInfo) {
		ICallback callback = new MyCallback();
		monitorService.deviceLogin(deviceInfo, callback);
		return callback.getResult();
	}
	
	
	@GetMapping("/exceptionDemo1")
	public Object exceptionDemo1() {
		throw new IllegalAccessError("测试异常1");
	}
	
	@GetMapping("/exceptionDemo2")
	public Object exceptionDemo2() {
		throw new ServiceException(ErrorCodeEnum.EquipmentNotFoundError);
	}
}
