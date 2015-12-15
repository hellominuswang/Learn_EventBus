package com.exa.learn_eventbus_0820;

public class FirstEvent {
	private String msg = null;
	public FirstEvent(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return msg;
	}

}
