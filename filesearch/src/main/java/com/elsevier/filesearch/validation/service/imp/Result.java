package com.elsevier.filesearch.validation.service.imp;

/**
 * This is a simple java class to store validation information
 * @author prate
 *
 */
public class Result {
	
	String message;
	boolean status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isAllGood() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
