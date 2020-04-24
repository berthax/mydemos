package com.device.monitor.common.exception;

import com.troila.cloud.respack.exception.BaseErrorException;

public class ServiceException extends BaseErrorException {

	private static final long serialVersionUID = 2501099390180112687L;

	public ServiceException(ErrorCodeEnum errorCodeEnum) {
		super(errorCodeEnum.code(), ErrorCodeEnum.getErrorMsg(errorCodeEnum.code()));
	}
	
	public ServiceException(ErrorCodeEnum errorCodeEnum, String message) {
		super(errorCodeEnum.code(), message);
	}
	
	public ServiceException(int errorCode,String message){
		super(errorCode, message);
	}
}
