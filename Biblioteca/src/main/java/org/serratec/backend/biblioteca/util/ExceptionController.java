package org.serratec.backend.biblioteca.util;

import org.serratec.backend.biblioteca.exceptions.BookNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> tratarBookNotFoundException(BookNotFoundException exception) {
		return ResponseEntity.notFound()
				.header("x-error-msg", exception.getMessage())
				.build();
	}
}
