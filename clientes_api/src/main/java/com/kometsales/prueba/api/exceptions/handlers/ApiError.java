package com.kometsales.prueba.api.exceptions.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime hora;
	private HttpStatus status;
	private String mensaje;

	private ApiError() {
		hora = LocalDateTime.now();
	}

	ApiError(HttpStatus status) {
		this();
		this.status = status;
	}

	ApiError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.mensaje = "Error inesperado";
	}

	ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.mensaje = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return mensaje;
	}

	public void setMessage(String message) {
		this.mensaje = message;
	}

	public String getInfoError() {
		StringBuilder str = new StringBuilder();
		str.append(" Código http: " + (this.status != null ? this.status.value(): null));
		str.append(" hora: " + (this.hora != null ? this.hora.toString(): null));
		str.append(" mensaje: " + this.mensaje);
		return str.toString();
	}
}
