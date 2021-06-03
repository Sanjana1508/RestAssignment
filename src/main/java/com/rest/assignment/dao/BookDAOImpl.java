package com.rest.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.assignment.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Book> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Book> theQuery = currentSession.createQuery("from Book",Book.class);
		List<Book> books = theQuery.getResultList();
		return books;
	}

	@Override
	public Book findById(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Book theBook = currentSession.get(Book.class,theId);
		return theBook;
	}

	@Override
	public void save(Book theBook) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		currentSession.saveOrUpdate(theBook);
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Book where id=:bookId");
		theQuery.setParameter("bookId", theId);
		theQuery.executeUpdate();
	}

}
