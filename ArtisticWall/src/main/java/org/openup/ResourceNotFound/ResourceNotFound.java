package org.openup.ResourceNotFound;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFound(String msg) {
		super(msg);
	}
	public ResourceNotFound(String msg, Throwable t) {
		super(msg, t);
	}

}
