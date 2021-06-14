package com.rest.assignment.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.rest.assignment.entity.Book;

public interface BookService {

	public List<Book> findAll(PageRequest pageRequest);
	
	
	public Book findById(int theId);
	
	public void save(Book theBook);
	
	public void deleteById(int theId);
	
	public List<Book> getAuthorBooks(int theId);
}
