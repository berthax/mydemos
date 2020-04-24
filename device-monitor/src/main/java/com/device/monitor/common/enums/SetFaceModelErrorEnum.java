package com.device.monitor.common.enums;

public enum SetFaceModelErrorEnum implements CodeValueEnum, DescriptionEnum{
	
	Callback_FaceModel_0_Error(0,"失败"),
	Callback_FaceModel_2_ERROR(2,"内存已满（人 脸数据满）"),
	Callback_FaceModel_3_ERROR(3,"卡权限不存在"),
	Callback_FaceModel_4_ERROR(4,"模板大小不对应");
	
	private int code;
	private String description;
	
	private SetFaceModelErrorEnum(int index, String description) {
		this.code = index;
		this.description = description;
	}

	@Override
	public int code() {
		return code;
	}

	@Override
	public String description() {
		return description;
	}

}
