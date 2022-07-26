package com.exception;

public class ApiException extends RuntimeException

{
	private static final long serialVersionsUID=1L;
	public ApiException(String message)
	{
		super(message);
	}
}
