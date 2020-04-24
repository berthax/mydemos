package com.device.monitor.controller.advice;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.troila.cloud.respack.core.AttrsSelector;
import com.troila.cloud.respack.core.RespAttrs;
import com.troila.cloud.respack.core.impl.DefaultRespAttrs;
import com.troila.cloud.respack.exception.BaseErrorException;

@Component
public class CustomAttrsSelector implements AttrsSelector{

	@SuppressWarnings("unchecked")
	@Override
	public <T extends RespAttrs> T selectResponseAtts(HttpServletResponse response) {
		
		DefaultRespAttrs attrs = new DefaultRespAttrs();
		attrs.setStatus(response.getStatus());
		String errCode = response.getHeader("err_code");
		if(!StringUtils.isEmpty(errCode)){
			attrs.setErrCode(Integer.valueOf(errCode));
			String error_msg = response.getHeader("err_msg");
			attrs.setMessage(error_msg);
			response.setContentType("application/json; charset=UTF-8");
		}else{
			attrs.setErrCode(0);
		}
		return (T) attrs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends RespAttrs> T selectExceptionAtts(HttpServletResponse response,BaseErrorException e) {
		DefaultRespAttrs attrs = new DefaultRespAttrs();
		attrs.setStatus(response.getStatus());
		attrs.setErrCode(e.getErrorCode());
		attrs.setMessage(e.getMessage());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Max-Age", "3600"); //设置预检请求的有效期
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept");
		response.setHeader("Access-Control-Allow-Methods", "*");
		return (T) attrs;
	}

}
