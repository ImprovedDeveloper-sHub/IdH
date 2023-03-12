package com.sbs.IdH.exception;

public class NotMultipartFormDataException extends Exception{
	
	public NotMultipartFormDataException() {
		super("mutipart 형식이 아닙니다.");
	}
}
