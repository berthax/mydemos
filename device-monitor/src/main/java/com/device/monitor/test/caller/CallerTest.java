package com.device.monitor.test.caller;

public class CallerTest {

	public static void main(String[] args) {
		Caller caller = new Caller();
		caller.setCallback(new MyCallbackImpl() {
			public void func() {
				System.out.println("aaaaaaaaaa");
			}
		});
		
		caller.doCallback();
	}
}
