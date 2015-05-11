package com.ccs.ems.svc;

import com.ccs.ems.model.Book;

public interface BookService {

	public Book saveBook(Book book);
	
	public Book getBook(Long bookId);
}
