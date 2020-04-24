package com.device.monitor.core.operation;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/**
 * 
 * <p>[功能描述]:综合操作里的默认实现</p>
 * <p>Copyright (c) Troila</p>
 * 
 * @author	宣国静
 * @version	2.0, 2020年4月23日
 * @since	Troila bertha
 *
 */
@Configuration
public class OperationAutoConfig {
	
	@Primary
	@Bean
	@ConditionalOnMissingBean(CompositeOperation.class)
	public Operation createDefaultCompositeOperation(List<Operation> operations) {
		System.out.println(operations);
		return new CompositeOperation(operations);
	}
}
