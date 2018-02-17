package com.suncap.bookstore.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.suncap.bookstore.security.domain.Book;
import com.suncap.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookResource {

	private String imageName;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Book addNewBook(@RequestBody Book book){
		return bookService.save(book);
	}
	
	@RequestMapping(value = "/add/image", method = RequestMethod.POST)
	public ResponseEntity upload(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request) {
		try {
			Book book = bookService.findOne(id);
			if(book == null) {
				return new ResponseEntity<>("upload failed", HttpStatus.BAD_REQUEST);
			}
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id + ".png";
			imageName = fileName;
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/images/" + fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity<>("upload success", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("upload failed", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Book updateBookPost(@RequestBody Book book){
		return bookService.save(book);
	}
	
	@RequestMapping(value = "/update/image", method = RequestMethod.POST)
	public ResponseEntity updateImage(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request) {
		try {
			Book book = bookService.findOne(id);
			if(book == null) {
				return new ResponseEntity<>("upload failed", HttpStatus.BAD_REQUEST);
			}
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id + ".png";
			
			Files.delete(Paths.get("src/main/resources/static/images/" + fileName));
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/images/" + fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity<>("upload success", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("upload failed", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/list")
	public List<Book> getBookList(){
		return bookService.findAll();
	}
	
	@RequestMapping("/{id}")
	public Book getBook(@PathVariable("id") Long id){
		return bookService.findOne(id);
	}
}
