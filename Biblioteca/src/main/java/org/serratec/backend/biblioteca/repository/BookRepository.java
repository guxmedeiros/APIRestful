package org.serratec.backend.biblioteca.repository;

import org.serratec.backend.biblioteca.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
