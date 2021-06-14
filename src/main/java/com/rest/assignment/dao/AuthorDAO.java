package com.rest.assignment.dao;

import java.util.List;

import com.rest.assignment.entity.Author;

public interface AuthorDAO {

	public List<Author> findAll();
	
	public Author findById(int theId);
	
	public void save(Author theAuthor);
	
	public void deleteById(int theId);
}
