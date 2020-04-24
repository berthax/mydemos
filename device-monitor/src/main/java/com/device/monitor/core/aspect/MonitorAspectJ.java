package com.device.monitor.core.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.device.monitor.common.exception.ErrorCodeEnum;
import com.device.monitor.common.exception.ServiceException;
import com.device.monitor.core.operation.Operation;
import com.troila.cloud.respack.exception.BaseErrorException;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MonitorAspectJ {

	@Autowired
	private Operation operation;
	
	@Pointcut("((execution(* com.device.monitor.controller..*.*(..))))")
	public void actionService() {}

	@Around(value = "actionService()")
	public Object aroundController(ProceedingJoinPoint proceedingJoinPoint) {
		if (log.isDebugEnabled()) {
    		log.debug("Enter: {}.{}() with argument[s] = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
    				proceedingJoinPoint.getSignature().getName(), Arrays.toString(proceedingJoinPoint.getArgs()));
		}
		try {
			Object aroundResult = proceedingJoinPoint.proceed();
			if (log.isDebugEnabled()) {
				log.debug("Exit: {}.{}() with result = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
						proceedingJoinPoint.getSignature().getName(), aroundResult);
			}
			operation.operate(aroundResult);
			return aroundResult;
		} catch (Throwable e) {
			log.error("异常信息如下：", e);
			if(e instanceof BaseErrorException) {
				BaseErrorException be = (BaseErrorException) e;
				throw be;
			}else if (e.getCause() instanceof BaseErrorException) {
				BaseErrorException be = (BaseErrorException) e.getCause();
				throw be;
			}
			throw new ServiceException(ErrorCodeEnum.Other,"系统内部异常，"+ e.getMessage());
		}
	}
}
