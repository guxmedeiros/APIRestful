package org.serratec.backend.crud.controller;


import java.util.List;

import org.serratec.backend.crud.entity.TodoEntity;
import org.serratec.backend.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping
	public List<TodoEntity> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public TodoEntity getId(@PathVariable Integer id) {
		return service.getId(id);
	}
	
	@PostMapping
	public void create(@RequestBody TodoEntity todo) {
		service.create(todo);
	}
	
	@PutMapping
	public void update(@RequestBody TodoEntity todo) {
		service.update(todo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
