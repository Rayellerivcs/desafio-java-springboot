package br.com.rayelle.product.service.exceptions;

public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BadRequestException(Exception message) {
		super("Bad Request: " + message.getMessage());
	}
}
