package com.ccs.ems.dao;

import java.io.File;

import com.ccs.ems.model.Book;

public interface BookDAO {

	 public Book saveBook(Book book);
	 
	 public Book getBook(Long bookId);

}
