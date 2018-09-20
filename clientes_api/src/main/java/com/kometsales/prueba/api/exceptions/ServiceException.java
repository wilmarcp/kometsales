package com.kometsales.prueba.api.exceptions;

public class ServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public static final String ERROR_BD = "Ocurrió un error accediendo a la base de datos";
	public static final String CLIENTE_YA_REGISTRADO = "El cliente ya se encuentra registrado";
	
	public ServiceException(String mensaje) {
		super(mensaje);
	}

	public ServiceException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}

}
