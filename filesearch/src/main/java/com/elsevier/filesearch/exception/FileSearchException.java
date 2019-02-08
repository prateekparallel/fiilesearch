package com.elsevier.filesearch.exception;

import org.springframework.http.HttpStatus;

/*
 * This a Exception class
 */

public class FileSearchException extends Throwable{
	
	
	private static final long serialVersionUID = 1L;
	HttpStatus status;
	

	public FileSearchException(String exm) {
		super(exm);
	}

	public HttpStatus getErrorCode() {
		return status;
	}


	public void setErrorCode(HttpStatus status) {
		this.status = status;
	}

}
