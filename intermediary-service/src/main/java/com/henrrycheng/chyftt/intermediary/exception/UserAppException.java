/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.henrrycheng.chyftt.intermediary.exception;

/**
 * 已知的无需打出log的用于提醒异常
 *
 * @author chengyong
 */
public class UserAppException extends  RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 提示代号
	 */
	private Long code;

	/**
	 * 给用户的提示异常信息
	 */
	private String userMessage;

	@SuppressWarnings("unused")
	private Throwable cause;


	public UserAppException(Long code, String message, String userMessage, Throwable cause) {
		super(message);
		this.cause = cause;
		this.code = code;
		this.userMessage = userMessage;
	}

	public UserAppException(String message, String userMessage, Throwable cause) {
		super(message);
		this.cause = cause;
		this.userMessage = userMessage;
	}

	public UserAppException(Long code, String message, String userMessage) {
		super(message);
		this.code = code;
		this.userMessage = userMessage;
	}

	public UserAppException(String message, String userMessage) {
		super(message);
		this.userMessage = userMessage;
	}

	public UserAppException(String userMessage) {
        super(userMessage);
        this.userMessage = userMessage;
    }

	public UserAppException(Long code) {
		super("错误码: " + code);
		this.code = code;
	}
    
	public String getUserMessage() {
		return userMessage;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
}
