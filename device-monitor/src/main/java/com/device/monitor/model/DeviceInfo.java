package com.device.monitor.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Builder(toBuilder = true)
@Accessors(chain=true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeviceInfo {
	/**
	 * 设备ip
	 */
	@NotBlank(message = "设备ip不能为空")
	private String ip;
	/**
	 * 设备端口
	 */
	@NotNull(message = "设备端口号不能为空")
	private Short port;
	/**
	 * 设备用户名
	 */
	@NotBlank(message = "设备登录用户名不能为空")
	private String username;
	/**
	 * 设备密码
	 */
	@NotBlank(message = "设备登录密码不能为空")
	private String password;
	/**
	 * 设备种类 建模设备，人脸设备，闸机
	 */
	private String kind;
	/**
	 * 设备型号
	 */
	private String type;
	/**
	 * 设备描述
	 */
	private String description;
}
