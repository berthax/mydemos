package com.device.monitor.core.store;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import com.sun.jna.NativeLong;

public interface Store<T> {
	
	void setOperationInfo(String key, T res);
	
	T getOperationInfo(String key);
	
	void removeOperationInfo(String key);
	
	void setLoginInfo(String key, NativeLong loginId);
	/**
	 * 
	 * <p>[功能描述]：清空登录信息</p>
	 * 
	 * @author	宣国静, 2019年12月25日
	 * @since	Troila  bertha
	 *
	 */
	void clearLoginInfo();
	
	NativeLong getLoginInfo(String key);
	
	void removeLoginInfo(String key);
	
	void setAlarmChanInfo(String key,NativeLong lHandlerAlarmChanId);
	
	NativeLong getAlarmChanInfo(String key);
	
	void removeAlarmChanInfo(String key);
	
	void setLockInfo(String key,Lock lock);
	
	Lock getLockInfo(String key);
	
	void removeLockInfo(String key);
	
	void setCountDownLatchInfo(String key,CountDownLatch countDownLatch);
	
	CountDownLatch getCountDownLatchInfo(String key);
	
	void removeCountDownLatchInfo(String key);
}
