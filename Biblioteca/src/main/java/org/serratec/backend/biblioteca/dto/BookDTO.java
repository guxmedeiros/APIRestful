package org.serratec.backend.biblioteca.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class BookDTO {
	
	@NotNull
	@Size(min = 5, max = 30)
	private String title;
	
	@NotNull
	@Size(min = 3, max = 20)
	private String type;
	
	@NotNull
	@Size(min = 10, max = 40)
	private String author;
	
	@Past
	private LocalDate publicationDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
	
}
