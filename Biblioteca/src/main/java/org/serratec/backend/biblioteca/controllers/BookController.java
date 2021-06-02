package org.serratec.backend.biblioteca.controllers;

import java.util.List;

import org.serratec.backend.biblioteca.dto.BookDTO;
import org.serratec.backend.biblioteca.exceptions.BookNotFoundException;
import org.serratec.backend.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getAll(@RequestParam(required = false, defaultValue = "id") String order ) {
		return new ResponseEntity<List<BookDTO>>(service.findAll(order), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getById(@PathVariable Long id) throws BookNotFoundException {
		return new ResponseEntity<BookDTO>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookDTO> create(@RequestBody BookDTO dto) {
		return new ResponseEntity<BookDTO>(service.create(dto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> update(@PathVariable  Long id, @RequestBody BookDTO dto) throws BookNotFoundException {
		return new ResponseEntity<BookDTO>(service.update(id, dto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable  Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}
}
