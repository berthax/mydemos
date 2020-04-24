package com.device.monitor.core.callback.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeviceCallbackFilterChain implements FilterChain {
	
	private List<DeviceCallbackFilterPerOnce> filters = new ArrayList<>();
	
	private int currentIndex = 0;
	
	private boolean isSort = false;
	
	
	public void addFilter(DeviceCallbackFilterPerOnce filter) {
		if(filter != null) {
			filters.add(filter);
			isSort = false;
		}
	}
	//对filter进行排序 order越小越靠前
	private void sortFilter() {
		Collections.sort(filters, new Comparator<DeviceCallbackFilterPerOnce>() {

			@Override
			public int compare(DeviceCallbackFilterPerOnce o1, DeviceCallbackFilterPerOnce o2) {
				return o1.getOrder()-o2.getOrder();
			}
			
		});
		isSort = true;
	}
	@Override
	public void doFilter(Object obj) {
		if(!isSort) {
			sortFilter();
		}
		if(currentIndex < filters.size()) {			
			DeviceCallbackFilter filter = filters.get(currentIndex);				
			currentIndex++;
//			log.info("执行第"+currentIndex+"过滤器:"+filter.getClass().getSimpleName());
			filter.doFilter(obj, this);
		}else {
			currentIndex = 0;
//			log.info("过滤连已经执行完毕");
		}
	}

}
