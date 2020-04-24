package com.device.monitor.common.enums;

/**
 * 
 * <p>[功能描述]:下发人脸时，经常遇到的错误码以及描述</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	1.0, 2019年11月13日
 * @since	Troila bertha
 *
 */
public enum FaceCallbackErrorEnum implements CodeValueEnum, DescriptionEnum{

	CALLBACK_FACE_0_ERROR(0,"失败"),
	CALLBACK_FACE_1_ERROR(1,"成功"),
	CALLBACK_FACE_2_ERROR(2,"重试或人脸质量差"),
	CALLBACK_FACE_3_ERROR(3,"内存已满"),
	CALLBACK_FACE_4_ERROR(4,"已存在该人脸"),
	CALLBACK_FACE_5_ERROR(5,"非法人脸ID"),
	CALLBACK_FACE_6_ERROR(6,"算法建模失败"),
	CALLBACK_FACE_7_ERROR(7,"未下发卡权限"),
	CALLBACK_FACE_8_ERROR(8,"未定义（保留）"),
	CALLBACK_FACE_9_ERROR(9,"人眼间距小"),
	CALLBACK_FACE_10_ERROR(10,"图片数据长度小于1KB"),
	CALLBACK_FACE_11_ERROR(11,"图片格式不符（png/jpg/bmp）"),
	CALLBACK_FACE_12_ERROR(12,"图片像素数量超过上限"),
	CALLBACK_FACE_13_ERROR(13,"图片像素数量低于下限"),
	CALLBACK_FACE_14_ERROR(14,"图片信息校验失败"),
	CALLBACK_FACE_15_ERROR(15,"图片解码失败"),
	CALLBACK_FACE_16_ERROR(16,"人脸检测失败"),
	CALLBACK_FACE_17_ERROR(17,"人脸评分失败");
	
	private int code;
	private String description;
	
	private FaceCallbackErrorEnum(int code, String description) {
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
