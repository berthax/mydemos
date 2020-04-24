package com.device.monitor.core.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
/**
 * 
 * <p>[功能描述]：整合所有的处理完之后的操作类
 * 比如：1.处理结果本地存储
 *       2.处理结果消息推送等</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月23日
 * @since	Troila bertha
 *
 */
public class CompositeOperation implements Operation{
	
	private final List<Operation> operationList;

	public CompositeOperation(List<Operation> operationList) {
		this.operationList = new ArrayList<Operation>(operationList);
	}
	
	@Override
	public void operate(Object object) {
		if(CollectionUtils.isEmpty(operationList)) {
			return;
		}
		for(Operation operation : operationList) {
			if(operation.support()) {
				operation.operate(object);				
			}
		}
	}

	@Override
	public boolean support() {
		return true;
	}
	
	public void addOperation(Operation operation) {
		if (operation == null) {
			throw new IllegalArgumentException("operation is null");
		}
		operationList.add(operation);
	}
}
