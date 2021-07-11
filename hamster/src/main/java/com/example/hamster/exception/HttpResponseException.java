package com.example.hamster.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpResponseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String responseBody;

	private int code;

	public HttpResponseException(String msg)
    {
        super(msg);
    }
}
