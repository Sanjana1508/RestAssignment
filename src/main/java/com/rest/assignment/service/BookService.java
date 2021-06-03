package com.rest.assignment.service;

import java.util.List;

import com.rest.assignment.entity.Book;

public interface BookService {

public List<Book> findAll();
	
	public Book findById(int theId);
	
	public void save(Book theBook);
	
	public void deleteById(int theId);
}
