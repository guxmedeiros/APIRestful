package org.serratec.backend.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.crud.entity.TodoEntity;
import org.serratec.backend.crud.exception.TodoNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	List<TodoEntity> lista = new ArrayList<TodoEntity>();
	
	public List<TodoEntity> getAll() {
		return lista;
	}
	
	public TodoEntity getId(Integer id) throws TodoNotFoundException {
		for (TodoEntity element : lista) {
			if(element.getId() == id) {
				return element;
			}
		}
		throw new TodoNotFoundException("Não foi possivel encontrar esse id: " + id);
	}
	
	public TodoEntity create(TodoEntity todo) {
		lista.add(todo);
		return todo;
	}
	
	public TodoEntity update(Integer id, TodoEntity todo) throws TodoNotFoundException {
		for (TodoEntity element : lista) {
			if (element.getId() == id) {
				if(todo.getNome() != null) {
					element.setNome(todo.getNome()); //Passando o que o usuario mandou no Objeto Todo para o meu Objeto da lista, todoEntity.
				}
				if(todo.getDescricao() != null) {
					element.setDescricao(todo.getDescricao());
				}
				return element;
			}
		}
		throw new TodoNotFoundException("Não foi possivel encontrar esse id: " + id);
	}
	
	public String delete(Integer id) throws Exception {
		for (TodoEntity element : lista) {
			if(element.getId() == id) {
				lista.remove(element);
				return "Deletado com sucesso";
			}
		}
		throw new Exception(" Não foi possivel deletar");
	}
}
