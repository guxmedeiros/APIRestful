package org.serratec.backend.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.crud.entity.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	List<TodoEntity> lista = new ArrayList<TodoEntity>();
	
	public List<TodoEntity> getAll() {
		return lista;
	}
	
	public TodoEntity getId(Integer id) {
		for (TodoEntity element : lista) {
			if(element.getId() == id) {
				return element;
			}
		}
		System.out.println("ID nao encontrado");
		return null;
	}
	
	public void create(TodoEntity todo) {
		lista.add(todo);
	}
	
	public void update(TodoEntity todo) {
		for (TodoEntity element : lista) {
			if(element.getId() == todo.getId()) {
				element.setNome(todo.getNome());
				element.setDescricao(todo.getDescricao());
				break;
			}
		}
		System.out.println("ID nao encontrado");
	}
	
	public void delete(Integer id) {
		for (TodoEntity element : lista) {
			if(element.getId() == id) {
				lista.remove(element);
				break;
			}
		}
		System.out.println("ID nao encontrado");
	}
}
