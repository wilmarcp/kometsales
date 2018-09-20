package com.kometsales.prueba.api.exceptions.handlers;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kometsales.prueba.api.exceptions.ServiceException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Solicitud erronea";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
		logger.error(ex.getMessage(), ex);
		return buildResponseEntity(construirApiError(HttpStatus.NOT_FOUND, ex));
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
		logger.error(ex.getMessage(), ex);
		return buildResponseEntity(construirApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex));
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(Exception ex) {
		logger.error(ex.getMessage(), ex);
		return buildResponseEntity(construirApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex));
	}

	@ExceptionHandler(ServiceException.class)
	protected ResponseEntity<Object> handleServiceException(ServiceException ex) {
		logger.error(ex.getMessage(), ex);
		return buildResponseEntity(construirApiError(HttpStatus.PRECONDITION_REQUIRED, ex));
	}
	
	private ApiError construirApiError(HttpStatus status, Throwable ex) {
		ApiError apiError = new ApiError(status);
		apiError.setMessage(ex.getMessage());
		return apiError;
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		logger.error(apiError.getInfoError());
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
