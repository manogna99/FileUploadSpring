package com.ccs.ems.svc;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccs.ems.dao.BookDAO;
import com.ccs.ems.model.Book;

public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.saveBook(book);
	}

	@Override
	public Book getBook(Long bookId) {
		// TODO Auto-generated method stub
		return bookDAO.getBook(bookId);
	}

}
