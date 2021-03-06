package com.rest.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.assignment.dao.BookDAO;
import com.rest.assignment.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional
	public List<Book> findAll(PageRequest pageRequest) {
		 
		return bookDAO.findAll(pageRequest);
	}

	@Override
	@Transactional
	public Book findById(int theId) {
		
		return bookDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Book theBook) {
		
		bookDAO.save(theBook);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		bookDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public List<Book> getAuthorBooks(int theId) {
		
		return bookDAO.getAuthorBooks(theId);
	}

}
