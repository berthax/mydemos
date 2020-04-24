package com.device.monitor.core.caller;

public interface ICallback {   
	/**
	 * 
	 * <p>[功能描述]：获取当前操作的执行进度</p>
	 * 
	 * @author	宣国静, 2020年4月24日
	 * @since	Troila  bertha
	 *
	 * @return
	 */
	int getProgress();
    /**
     * 
     * <p>[功能描述]：获取当前操作的执行结果</p>
     * 
     * @author	宣国静, 2020年4月24日
     * @since	Troila  bertha
     *
     * @return
     */
    Object getResult();
    
    void setProgress(int progeress);
    
    void setResult(Object object);
}
