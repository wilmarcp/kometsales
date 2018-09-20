package com.kometsales.prueba.api.exceptions;

public class DAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public DAOException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}	
}
