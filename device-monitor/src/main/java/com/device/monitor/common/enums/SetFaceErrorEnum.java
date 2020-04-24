package com.device.monitor.common.enums;

/**
 * 
 * <p>[功能描述]:下发人脸可能的错误码</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月24日
 * @since	Troila bertha
 *
 */
public enum SetFaceErrorEnum implements CodeValueEnum, DescriptionEnum{
	SetFace0Error(0,"失败"),
	SetFace1Error(1,"成功"),
	SetFace2Error(2,"重试或人脸质量差"),
	SetFace3Error(3,"内存已满"),
	SetFace4Error(4,"已存在该人脸"),
	SetFace5Error(5,"非法人脸ID"),
	SetFace6Error(6,"算法建模失败"),
	SetFace7Error(7,"未下发卡权限"),
	SetFace8Error(8,"未定义（保留）"),
	SetFace9Error(9,"人眼间距小"),
	SetFace10Error(10,"图片数据长度小于1KB"),
	SetFace11Error(11,"图片格式不符（png/jpg/bmp）"),
	SetFace12Error(12,"图片像素数量超过上限"),
	SetFace13Error(13,"图片像素数量低于下限"),
	SetFace14Error(14,"图片信息校验失败"),
	SetFace15Error(15,"图片解码失败"),
	SetFace16Error(16,"人脸检测失败"),
	SetFace17Error(17,"人脸评分失败");
	
	private int code;
	private String description;

	private SetFaceErrorEnum(int code, String description) {
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
