package com.sbs.IdH.exception;

public class InvalidPasswordException extends Exception{

	public InvalidPasswordException() {
		super("패스워드가 일치하지 않습니다.");
	}
}
