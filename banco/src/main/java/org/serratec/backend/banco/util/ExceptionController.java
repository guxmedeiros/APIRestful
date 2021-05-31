package org.serratec.backend.banco.util;

import org.serratec.backend.banco.exceptions.ContaNotFoundException;
import org.serratec.backend.banco.exceptions.SaldoInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(ContaNotFoundException.class)
	public ResponseEntity<String> tratarContaNotFoundException(ContaNotFoundException exception) {
		return ResponseEntity.notFound().header("x-error-msg", exception.getMessage()).build();
	}
	
	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<String> tratarSaldoInsuficienteException(SaldoInsuficienteException exception) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.header("x-error-msg", exception.getMessage())
				.build();
	}
}
