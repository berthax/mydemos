package com.device.monitor.common.enums;

/**
 * 
 * <p>[功能描述]:获取GetLastError时常遇到的错误码</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	1.0, 2019年11月13日
 * @since	Troila bertha
 *
 */
public enum LastErrorCodeEnum implements CodeValueEnum, DescriptionEnum{
	
	CONNECTION_TIMEOUT(7,"连接设备失败"),
	SEND_FAIL(8,"向设备发送失败"),
	/**
	 * 从建模设备中获取不到人脸数据时会报此错误
	 * （没有和传入的卡号参数绑定的人脸数据）
	 */
	RECEIVE_DATA_FAIL(9,"从设备接收数据失败"),
	/**
	 * 从建模设备获取人脸信息时出现过此问题，造成的原因是因为多个人脸设备同时访问建模设备造成的资源抢占，
	 * 在调用获取人脸数据的方法除加入了锁，此问题得以解决。
	 */
	RESOURCES_INSUFFICIENT(28,"设备资源不足"),
	/**
	 * SDK资源分配错误
	 * 由于建立建立的长连接没有及时关闭，导致长连接数量达到设备能力上限（上限为2040个长连接）
	 */
	RESOURCES_MISSALLOCATION(41,"SDK资源分配错误"),
	/**
	 * 注册的用户ID已注销或不可用,webserver中存在脏数据，一般解决方法是清空缓存
	 */
	USER_NOTFOUND(47,"用户不存在"),
	/**
	 * 登录失败返回错误值，说明设备已经被登录
	 */
	MAX_NUM_USERS(52,"登录设备的用户数达到最大"),
	/**
	 * 布防的最大数量为1次，人脸设备已布防状态下再次调用布防接口就会报此错误
	 */
	SET_ALAEMCHAN_ERROR(1924,"布防超过最大连接数");
	
	private int code;
	private String description;

	
	private LastErrorCodeEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public String description() {
		return description;
	}

	@Override
	public int code() {
		return code;
	}

}
