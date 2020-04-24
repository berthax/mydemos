package com.device.monitor.controller.advice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.device.monitor.common.exception.ErrorCodeEnum;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {
	/**
	 * 
	 * <p>[功能描述]：处理MethodArgumentNotValid异常</p>
	 * 
	 * @author	宣国静, 2019年10月31日
	 * @since	Troila bertha
	 *
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("【MethodArgumentNotValidException异常捕获】异常信息如下:",ex);
		BindingResult result = ex.getBindingResult();
	    Map<String, String> maps = getAllErrors(result);    
	    headers.add("err_code", String.valueOf(ErrorCodeEnum.ParamValidError.code()));
	    StringBuilder sb = new StringBuilder();
	    maps.forEach((key, value)->{
	    	sb.append(key).append(":").append(value).append(";");
        });
	    headers.add("err_msg", sb.toString());
	    return new ResponseEntity<>(null, headers, HttpStatus.OK);
	}
		
	/**
	 * 
	 * <p>[功能描述]：处理BindException异常</p>
	 * 
	 * @author	宣国静, 2019年10月31日
	 * @since	Troila bertha
	 *
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		log.error("【BindException异常捕获】异常信息如下:",ex);
		BindingResult result = ex.getBindingResult();
	    Map<String, String> maps = getAllErrors(result);    
	    headers.add("err_code", String.valueOf(ErrorCodeEnum.ParamValidError.code()));
	    StringBuilder sb = new StringBuilder();
	    maps.forEach((key, value)->{
	    	sb.append(key).append(":").append(value).append(";");
        });
	    headers.add("err_msg", sb.toString());
	    return new ResponseEntity<>(null, headers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * <p>[功能描述]：获取校验异常中的错误信息</p>
	 * 
	 * @author	宣国静, 2019年10月31日
	 * @since	Troila  bertha
	 *
	 * @param bindingResult
	 * @return
	 */
	private Map<String, String> getAllErrors(BindingResult bindingResult){
		Map<String, String> maps;		 
	    if (bindingResult.hasErrors()) {
	        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
	        maps = new HashMap<>(fieldErrors.size());
	        fieldErrors.forEach(error -> {
	            maps.put(error.getField(), error.getDefaultMessage());
	        });
	    } else {
	        maps = Collections.emptyMap();
	    }	   
	    return maps;
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("【HttpMessageNotReadable异常捕获】异常信息为:",ex.getCause());
		if((ex.getCause()) instanceof InvalidFormatException){
			headers.add("err_code", String.valueOf(ErrorCodeEnum.DataConverterError.code()));
			headers.add("err_msg", ErrorCodeEnum.DataConverterError.description());			
		}else {
			headers.add("err_code", String.valueOf(ErrorCodeEnum.ParamValidError.code()));
			headers.add("err_msg", "参数异常");		
		}
	    return new ResponseEntity<>(null, headers, HttpStatus.OK);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		log.error("【其他异常捕获】异常信息为:",ex);
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
}
