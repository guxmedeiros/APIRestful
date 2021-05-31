package org.serratec.backend.crud.util;

import org.serratec.backend.crud.exception.TodoNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {
	@ExceptionHandler(TodoNotFoundException.class)
	public ResponseEntity<String> tratandoTodoNotFoundException(TodoNotFoundException exception) {
		return ResponseEntity.notFound()
				.header("x-erro-msg", exception.getMessage())
				.build();
	}
}
