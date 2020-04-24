package com.device.monitor.common.constant;
/**
 * 
 * <p>[功能描述]系统用到的一些常量</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月24日
 * @since	Troila bertha
 *
 */
public abstract class CommonConstant {
	public static final String DEFAULT_PASSWORD = "123456";
	/**
	 * 下发卡参数时，设置卡的状态为1，为有效
	 */
	public static final byte OPERATION_CARD_ENABLE = 1;
	/**
	 * 删除卡参数时，设备卡的状态为0，为无效
	 */
	public static final byte OPERATION_CARD_DISABLE = 0;
	/**
	 * 人脸设备扫脸回调命令码
	 */
	public static final int ALARM_CALLBACK_FACE = 20482;
	/**
	 * 人脸设备刷身份证回调命令码
	 */
	public static final int ALARM_CALLBACK_IDCARD = 20992;
	
	public static final String EMPLOYEE_CARD_PREFIX = "YG-";
	
	public static final String TOURIST_CARD_PREFIX = "FK-";
	
	public static final int FACE_TYPE_ENTER = 1;
	
	public static final int FACE_TYPE_LEAVE = 2;

}
