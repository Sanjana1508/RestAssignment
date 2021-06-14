package com.rest.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.assignment.dao.AuthorDAO;
import com.rest.assignment.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDAO;
	
	@Override
	@Transactional
	public List<Author> findAll() {
		
		return authorDAO.findAll();
	}

	@Override
	@Transactional
	public Author findById(int theId) {
		
		return authorDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Author theAuthor) {
		authorDAO.save(theAuthor);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		authorDAO.deleteById(theId);

	}

}
