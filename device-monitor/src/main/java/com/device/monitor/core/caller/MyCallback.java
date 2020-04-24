package com.device.monitor.core.caller;

public class MyCallback implements ICallback{

	private int progress;
	private Object object;
	
	@Override
	public int getProgress() {
		return progress;
	}

	@Override
	public Object getResult() {
		return object;
	}

	@Override
	public void setProgress(int progeress) {
		this.progress = progeress;
	}

	@Override
	public void setResult(Object object) {
		this.object = object;
	}

}
