package com.device.monitor.core.operation;
/**
 * 
 * <p>[功能描述]:对设备分析完的结果进行处理操作的接口</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月23日
 * @since	Troila bertha
 *
 */
public interface Operation {
	
	public void operate(Object object);
	
	public boolean support();
}
