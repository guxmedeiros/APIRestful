package org.serratec.backend.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.biblioteca.dto.BookDTO;
import org.serratec.backend.biblioteca.entity.BookEntity;
import org.serratec.backend.biblioteca.exceptions.BookNotFoundException;
import org.serratec.backend.biblioteca.mapper.BookMapper;
import org.serratec.backend.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	BookMapper mapper;
	
	
	public List<BookDTO> findAll(String order) {
		List<BookEntity> list = repository.findAll(Sort.by(order));
		List<BookDTO> listDTO = new ArrayList<BookDTO>();
		for (BookEntity listEntity : list) {
			listDTO.add(mapper.toDTO(listEntity));
		}
		return listDTO;
//		return repository.findAll(Sort.by(order)).stream().map(mapper::toDTO).collect(Collectors.toList());
	}
	
	public BookDTO findById(Long id) throws BookNotFoundException {
		Optional<BookEntity> book = repository.findById(id);
		if (book.isPresent() ) {
			return mapper.toDTO(book.get());
		}
		throw new BookNotFoundException("Livro nao encontrado");
	}
	
	public BookDTO create(BookDTO dto) {
		return mapper.toDTO(repository.save(mapper.toEntity(dto)));
	}
	
	public BookDTO update(Long id, BookDTO entity) throws BookNotFoundException {
		BookEntity book = mapper.toEntity(this.findById(id));
		if (entity.getTitle() != null) {
			book.setTitle(entity.getTitle());
		}
		if (entity.getAuthor() != null) {
			book.setAuthor(entity.getAuthor());
		}
		if (entity.getType() != null) {
			book.setType(entity.getType());
		}
		if (entity.getPublicationDate() != null) {
			book.setPublicationDate(entity.getPublicationDate());
		}
		return mapper.toDTO(repository.save(book));

	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
