package com.device.monitor.core.store;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

import com.device.monitor.model.SingleOperationRes;
import com.sun.jna.NativeLong;

public class RedisStore implements Store<SingleOperationRes>{

	@Override
	public void setOperationInfo(String key, SingleOperationRes res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SingleOperationRes getOperationInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOperationInfo(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginInfo(String key, NativeLong loginId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NativeLong getLoginInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLoginInfo(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAlarmChanInfo(String key, NativeLong lHandlerAlarmChanId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NativeLong getAlarmChanInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAlarmChanInfo(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLockInfo(String key, Lock lock) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lock getLockInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLockInfo(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearLoginInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CountDownLatch getCountDownLatchInfo(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCountDownLatchInfo(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCountDownLatchInfo(String key, CountDownLatch countDownLatch) {
		// TODO Auto-generated method stub
		
	}

}
