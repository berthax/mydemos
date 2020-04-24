package com.device.monitor.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(chain=true)
public class SingleOperationRes {
	/**
	 * 与web端约定的操作的唯一编码
	 */
	private final String code;
	/**
	 * 用于标识这条数据的操作信息的 code_设备ip_操作的数据，
	 * 以保证唯一性
	 * 此信息主要用于批量下发的时候，区分单个的操作结果的
	 */
	private final String innerCode;
	
	/**
	 * 操作的数据的卡号为,这里只记录操作的卡号，不记录操作的图片信息等了
	 */
	private final String data;
	/**
	 * 操作的ip
	 */
	private final String ip;
	/**
	 * 操作类型
	 */
	private final String operationType;
	/**
	 * 操作的设备类型
	 */
	private final String deviceType;	
	/**
	 * 操作结果状态
	 */
	@Setter
	private boolean status;
	/**
	 * 如果发生错误，填写此错误码,不是设备返回的错误码，业务错误码填99999
	 * 0代表没有错误
	 */
	@Setter
	private Integer errorCode = 0;
	/**
	 * 错误描述
	 */
	@Setter
	private String errorMsg = "";
	/**
	 * 完成时间
	 */
	@Setter
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date completeTime;
	
	/**
	 * 操作是否完成的标志，用于在主线程判断是否结束等待，
	 * 为了限制乱操作，此状态只能操作一次(因为比如下发图片成功之后，还会调用1000，1002,不能再由成功结束的状态置为失败)
	 */
	@JsonIgnore
	private boolean completeStatus;
	
	@JsonIgnore
	private boolean isSetCompleteStatus;
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String res = "";
		try {
			res = mapper.writeValueAsString(this);
			return res;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 
	 * <p>[功能描述]： 在invoker中,当判定某个操作执行完成时调用</p>
	 * 比如下发卡参数，当dwType=0，并且计算的状态码为1000时调用，
	 * 当下发照片，当dwType=2时，调用
	 * @author	宣国静, 2019年11月6日
	 * @since	Troila  bertha
	 *
	 */
	public void complete() {
		if(!isSetCompleteStatus){
			this.completeStatus = true;
			isSetCompleteStatus = true;
		}
	}
	
	/**
	 * 
	 * <p>[功能描述]：在主线程中调用，判断操作是否完成</p>
	 * 
	 * @author	宣国静, 2019年11月6日
	 * @since	Troila  bertha
	 *
	 * @return
	 */
	public boolean isComplete() {
		return this.completeStatus;
	}

	public void resetComplete() {
		this.completeStatus = false;
		this.isSetCompleteStatus = false;
	}
	
	/**
	 * 
	 * <p>[方法描述]：初始化所有final类型的字段，
	 * 一旦创建对象，这些字段不允许再修改</p>
	 * 
	 * @param code
	 * @param data
	 * @param ip
	 * @param operationType
	 * @param deviceType
	 */
	public SingleOperationRes(String code, String data, String ip, String operationType, String deviceType,String innerCode) {
		super();
		this.code = code;
		this.data = data;
		this.ip = ip;
		this.operationType = operationType;
		this.deviceType = deviceType;
		this.innerCode = innerCode;
	}
}
