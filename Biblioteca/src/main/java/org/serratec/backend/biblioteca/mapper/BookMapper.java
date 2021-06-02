package org.serratec.backend.biblioteca.mapper;

import org.serratec.backend.biblioteca.dto.BookDTO;
import org.serratec.backend.biblioteca.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
	
	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		entity.setTitle(dto.getTitle());
		entity.setType(dto.getType());
		entity.setAuthor(dto.getAuthor());
		entity.setPublicationDate(dto.getPublicationDate());
		
		return entity;
	}
	
	public BookDTO toDTO(BookEntity entity) {
		BookDTO dto = new BookDTO();
		dto.setTitle(entity.getTitle());
		dto.setType(entity.getType());
		dto.setAuthor(entity.getAuthor());
		dto.setPublicationDate(entity.getPublicationDate());
		
		return dto;
	}
}
