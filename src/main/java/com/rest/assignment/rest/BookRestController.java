package com.rest.assignment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.assignment.entity.Book;
import com.rest.assignment.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return bookService.findAll();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		Book theBook = bookService.findById(bookId);
		
		if(theBook ==null)
			throw new BookNotFoundException("Book Not found : "+bookId);
		
		return theBook;
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book theBook) {
		theBook.setId(0);
		
		bookService.save(theBook);
		
		return theBook;
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book theBook) {
		bookService.save(theBook);
		
		return theBook;
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int  bookId) {
		Book theBook = bookService.findById(bookId);
		
		if(theBook ==null)
			throw new BookNotFoundException("Book Not found : "+bookId);
		
		bookService.deleteById(bookId);
		
		return "Deleted Book id : "+bookId;
	}
	
}
