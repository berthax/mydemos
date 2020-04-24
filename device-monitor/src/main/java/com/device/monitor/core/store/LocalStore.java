package com.device.monitor.core.store;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.device.monitor.model.SingleOperationRes;
import com.sun.jna.NativeLong;

@Primary
@Component
@ConditionalOnMissingBean(Store.class)
public class LocalStore implements Store<SingleOperationRes> {
	/**
	 * 存储当前登录过的设备，用登录句柄复用
	 */
	public static final Map<String,NativeLong> loginMap = new ConcurrentHashMap<String, NativeLong>();
	/**
	 * 操作信息map，key为操作的innerCode，value为操作结果
	 */
	public static final Map<String,SingleOperationRes> operationInfoMap = new ConcurrentHashMap<String, SingleOperationRes>();	
	/**
	 * 布防句柄存储,key为设备的ip，value为设备布防的句柄
	 */
	public static final Map<String,NativeLong> lHandleAlarmChanMap = new ConcurrentHashMap<>();
	
	/**
	 * 当处理批量操作时，存储结果信息的，外层的key为与web端商定的唯一编码，内层的key为 当前操作的数据卡号-设备ip组成
	 */
	public static final Map<String,List<SingleOperationRes>> batchOperationInfoMap = new ConcurrentHashMap<>();	
	/**
	 * 锁的map，用在剔除操作中，对同一个设备的多数据卡号剔除，走单线程
	 * key为设备的ip，value为该设备对应的锁
	 */
	public static final Map<String,Lock> lockMap = new ConcurrentHashMap<>();
	/**
	 * 用于批量操作时，主线程和子线程协调进度的，key为批量操作的唯一操作码
	 */
	public static final Map<String,CountDownLatch> countDownLatchMap = new ConcurrentHashMap<>();
	
	@Override
	public void setOperationInfo(String key, SingleOperationRes res) {
		operationInfoMap.put(key, res);
	}

	@Override
	public SingleOperationRes getOperationInfo(String key) {
		return operationInfoMap.get(key);
	}

	@Override
	public void removeOperationInfo(String key) {
		operationInfoMap.remove(key);
	}

	@Override
	public void setLoginInfo(String key, NativeLong loginId) {
		loginMap.put(key, loginId);
	}

	@Override
	public NativeLong getLoginInfo(String key) {
		return loginMap.get(key);
	}

	@Override
	public void removeLoginInfo(String key) {
		loginMap.remove(key);
	}

	@Override
	public void setAlarmChanInfo(String key, NativeLong lHandlerAlarmChanId) {
		lHandleAlarmChanMap.put(key, lHandlerAlarmChanId);
	}
	
	@Override
	public NativeLong getAlarmChanInfo(String key) {
		return lHandleAlarmChanMap.get(key);
	}

	@Override
	public void removeAlarmChanInfo(String key) {
		lHandleAlarmChanMap.remove(key);
	}

	@Override
	public void setLockInfo(String key, Lock lock) {
		lockMap.put(key, lock);
	}

	@Override
	public Lock getLockInfo(String key) {
		Lock lock = lockMap.get(key);
		if(Objects.isNull(lock)) {
			lock = new ReentrantLock();
			lockMap.put(key, lock);
		}
		return lock;
	}

	@Override
	public void removeLockInfo(String key) {
		lockMap.remove(key);
	}

	@Override
	public void clearLoginInfo() {
		// 步骤1，注意此处应该调用logout方法，先注销SDK资源
		
		// 步骤2，将登录句柄的缓存清空
		loginMap.clear();
	}

	@Override
	public void setCountDownLatchInfo(String key,CountDownLatch countDownLatch) {
		countDownLatchMap.put(key, countDownLatch);
	}

	@Override
	public CountDownLatch getCountDownLatchInfo(String key) {
		return countDownLatchMap.get(key);
	}

	@Override
	public void removeCountDownLatchInfo(String key) {
		countDownLatchMap.remove(key);
	}


}
