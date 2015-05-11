package com.ccs.ems.dao;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccs.ems.model.Book;

public class BookDAOImpl implements BookDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	/**
	  * Inserts a row in the BOOK table.
	  * Do not need to pass the id, it will be generated.
	  * @param book
	  * @return an instance of the object Book
	  */

	 public Book saveBook(Book book)
	 {
	  Session session = sessionFactory.openSession();
	  Transaction transaction = null;
	  try {
	   transaction = session.beginTransaction();
	   session.save(book);
	   transaction.commit();
	  } catch (HibernateException e) {
	   transaction.rollback();
	   e.printStackTrace();
	  } finally {
	   session.close();
	  }
	  return book;
	 }
	 
	 /**
	   * Delete a book from database
	   * @param bookId id of the book to be retrieved
	   */
	  public Book getBook(Long bookId)
	  {
	   Session session = sessionFactory.openSession();
	   try {
	    Book book = (Book) session.get(Book.class, bookId);
	    return book;
	   } catch (HibernateException e) {
	    e.printStackTrace();
	   } finally {
	    session.close();
	   }
	   return null;
	  }


}
