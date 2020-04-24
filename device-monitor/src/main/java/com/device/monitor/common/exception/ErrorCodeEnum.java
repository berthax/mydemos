package com.device.monitor.common.exception;

import org.springframework.util.StringUtils;

import com.device.monitor.common.enums.CodeValueEnum;
import com.device.monitor.common.enums.DescriptionEnum;
import com.device.monitor.common.util.EnumUtils;


public enum ErrorCodeEnum implements CodeValueEnum, DescriptionEnum {
	// 系统管理 10开头
	// 预约管理 PC端 20开头  包括微信端
	// 人员信息 30开头
	// 设备管理  40开头  设备操作41开头
	// 过程追溯 50开头 
	
	// 1  AuthAndRole
	UserNameOrPasswordError(10001, "用户名或密码错误"),
	UserForbidden(10002, "该账号已禁用，请联系管理员"),
	NotMyUserAuth(10003, "非本用户记录，无权进行此项操作"),  
	LoginPasswordError(10004, "密码错误"),
	UniqueCodeExistsError(10005, "唯一编码已存在"),
	DictCodeExistsError(10006, "KEY已存在"),
	ParamMissingError(10007, "参数缺失"),
	UsernameExistsError(10008, "该用户名已存在"),
	UserNotFoundError(10009, "该用户不存在"),
	DataNotFoundError(10010, "数据查询不到"),
	ClientNotRegistered(10011,"客户端未在认证中心注册"),	
	ClientSecretError(10012,"客户端密钥错误"),
	UserIsDeleted(10013,"用户已删除"),	
	UserStatusAbnormal(10014,"用户状态异常"),
	LoginError(10015,"登录发生错误"),
	UsernameOrPasswordBlankError(10016,"用户名或密码不能为空"),
	NotSupportGrantTypeError(10017,"暂不支持的授权类型"),
			
	//认证相关错误码
	TokenError(10020, "访问失败，请求中没有携带token"),
	TokenFalt(10021, "token签证失败，token不存在或者错误"),
	TokenExpired(10022,"token已过期"),
	PermissionsError(10030, "该账号没有对应权限"),
	
	// 2 预约管理
	ImgDataError(20001,"图片数据有误"),
	
	NotFindEquipmentError(20002,"查询不到被访人信息"),
	
	
	// 3 人员信息
	
	// service
	DatabaseQueryError(40001, "数据库查询异常"),
	DataOperationError(40002, "数据库操作异常"),	  //用于保存 更新  删除等
	EquipmentNotFoundError(40003, "设备录未找到"),
	ServiceQueryError(40007, "业务查询参数异常"),
	IPRepeatError(40008, "设备IP重复"),
	IPConnectError(40009, "设备IP访问失败"),
	
	// 设备操作异常
	DeviceOperationError(41000,"调用设备异常"),
	
	// 99   Other
	NerworkError(99991,"网络错误"),
	SQLError(99992, "SQL错误"),
	ScheduleError(99993, "定时任务错误"),
	DataConverterError(99994,"数据类型转换异常"),
	ExcelError(99995, "Excel文件错误"),
	ImgError(99996, "图片错误"),
	PcsError(99997, "加密错误"),
	ParamValidError(99998,"参数校验异常"),
	Other(999999, "服务器内部错误，请联系管理员");
	
	
	private int code;
	private String description;

	ErrorCodeEnum(int code,String description) {
		this.code = code;
		this.description = description;
	}
	
	@Override
	public int code() {
		return this.code;
	}
	
	@Override
	public String description() {
		return this.description;
	}

	public static String getErrorMsg(int code) {
		String message = EnumUtils.descOfCode(ErrorCodeEnum.class, code);
        return StringUtils.isEmpty(message) ? "未知错误" : message;    
	}
}
