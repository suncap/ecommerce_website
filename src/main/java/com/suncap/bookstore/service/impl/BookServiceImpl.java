package com.suncap.bookstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suncap.bookstore.repository.BookRepository;
import com.suncap.bookstore.security.domain.Book;
import com.suncap.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository repository;
	
	@Override
	public List<Book> findAll() {
		List<Book> books = (List<Book>) repository.findAll();
		return books.stream().filter(b -> b.active).collect(Collectors.toList());
	}

	@Override
	public Book findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book save(Book book) {
		return repository.save(book);
	}

	@Override
	public List<Book> blurrySearch(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOne(Long id) {
		// TODO Auto-generated method stub
		
	}

}
