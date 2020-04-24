package com.device.monitor.common.enums;

public enum DeviceOperationErrorEnum implements CodeValueEnum, DescriptionEnum{
	
	DeviceLoginError(41001,"设备登录失败"),
	GetConnectionError(41002,"建立长连接失败"),
	SendConnectionError(41003,"发送长连接失败"),
	WaitCallbackTimeoutError(41004,"等待回调超时"),
	WaitCallbackInterruptedError(41005,"回调中断异常"),
	LockInterruptedError(41006,"锁中断异常"),
	GatewayOpenError(41007,"闸机开启失败"),
	DeviceBusyError(41008,"设备繁忙"),
	DeviceOperationError(41009,"设备操作异常"),
	DataModelingError(41010,"建模失败"),
	SetAlarmCallbackError(41011,"布防设置回调函数失败"),
	SetAlarmError(41012,"布防失败"),
	CloseAlarmNoAlarmChanError(41013,"当前设备没有布防"),
	CloseAlarmChanHanlderDisableError(41014,"布防句柄无效"),
	CloseAlarmChanError(41015,"撤防失败"),
	ImageDataValidError(41016,"图像数据为空或不合法"),
	WaitSubOperationResultTimeout(41017,"等待子操作结果超时"),
	
	RemoveCardError(41019,"删除卡号失败"),
	RemoveImageError(41020,"删除人脸照片失败"),
	ClearImagesError(41021,"清除人脸数据失败"),
	ClearCardsError(41022,"清除卡号数据失败"),
	
	ServiceError(41100,"业务异常"),
	ParamValidError(99998,"参数校验异常"),
	UNKOWN_ERROR(99999,"未知错误");
	
	private int code;
	private String description;
	
	private DeviceOperationErrorEnum(int code,String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public String description() {
		return this.description;
	}

	@Override
	public int code() {
		return this.code;
	}
}
