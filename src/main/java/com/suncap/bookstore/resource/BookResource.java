package com.suncap.bookstore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suncap.bookstore.security.domain.Book;
import com.suncap.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookResource {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Book addNewBook(@RequestBody Book book){
		return bookService.save(book);
	}
	
}
