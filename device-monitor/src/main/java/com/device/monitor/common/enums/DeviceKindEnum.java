package com.device.monitor.common.enums;

public enum DeviceKindEnum  implements CodeValueEnum, DescriptionEnum{

	Model(1,"建模设备"),
	Face(2,"人脸设备"),
	Gateway(3,"闸机"),
	SuperBrain(4,"超脑");
		
	private int code;
	private String description;
	
	private DeviceKindEnum(int code, String description) {
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
