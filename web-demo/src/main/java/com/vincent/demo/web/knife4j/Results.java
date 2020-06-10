package com.vincent.demo.web.knife4j;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("通用接口返回对象")
public class Results<T> {
	@ApiModelProperty(required = true, notes = "状态码", example = "200")
	private int state;
	
	@ApiModelProperty(required = true, notes = "时间戳", example = "1567425139000")
	private long time;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	@ApiModelProperty(required = true, notes = "返回信息", example = "success")
	private String message;
	
	@ApiModelProperty(required = true, notes = "返回数据", example = "{\"name\":\"blues\"}")
	private T content;
	
	public Results(int code, String msg, T obj) {
		setState(code);
		setMessage(msg);
		setContent(obj);
	}
}
