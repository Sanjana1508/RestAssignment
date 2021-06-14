package com.rest.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.assignment.entity.Author;
import com.rest.assignment.entity.Book;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Author> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Author> theQuery = currentSession.createQuery("from Author",Author.class);
		List<Author> authors = theQuery.getResultList();
		return authors;
	}

	@Override
	public Author findById(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Author theAuthor = currentSession.get(Author.class,theId);
		return theAuthor;
	}

	@Override
	public void save(Author theAuthor) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theAuthor);

	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Author where id=:authorId");
		theQuery.setParameter("authorId", theId);
		theQuery.executeUpdate();

	}

}
