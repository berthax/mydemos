package com.device.monitor.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;
@Configuration
@EnableAsync
@Slf4j
public class AsyncThreadConfig implements AsyncConfigurer{

	@Override
	public Executor getAsyncExecutor() {
		
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(5);
	    executor.setMaxPoolSize(15);
	    executor.setThreadNamePrefix("Anno-Executor");
	    executor.setQueueCapacity(25);
	    executor.initialize();
	    log.info("Asyn ThreadPool initialize complete ..");
	    // 设置拒绝策略
//	    executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
//	        @Override
//	        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//	            // .....
//	            System.out.println("do somethings by myself ...");
//	        }
//	    });
	    // 使用预定义的异常处理类
	    // 拒绝策略，执行调用任务的run()方法，绕过线程池直接执行
	    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	    return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	    return null;
	}
	
}
