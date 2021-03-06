package com.rest.assignment.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.assignment.entity.Author;
import com.rest.assignment.entity.Book;
import com.rest.assignment.service.AuthorService;
import com.rest.assignment.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	//implement pagination
	///lazy loading eager loading
	//lombok 
	//author and book
	@GetMapping("/")
	public List<Book> getBooks(@RequestParam int page, @RequestParam int limit,
			@RequestParam Optional<String> sortBy){
		return bookService.findAll(PageRequest.of(page,limit,Sort.Direction.ASC,sortBy.orElse("id")));
	}
	
	
	
	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		Book theBook = bookService.findById(bookId);
		
		if(theBook ==null)
			throw new BookNotFoundException("Book Not found : "+bookId);
		
		return theBook;
	}
	
	@PostMapping("/")
	public Book addBook(@RequestBody Book theBook) {
		theBook.setId(0);
		
		List<Author> authors = theBook.getAuthors();
		for(Author a: authors)
			authorService.save(a);
		
		bookService.save(theBook);
		return theBook;
	}
	
	@PutMapping("/")
	public Book updateBook(@RequestBody Book theBook) {
		bookService.save(theBook);
		
		return theBook;
	}
	
	@DeleteMapping("/{bookId}")
	public String deleteBook(@PathVariable int  bookId) {
		Book theBook = bookService.findById(bookId);
		
		if(theBook ==null)
			throw new BookNotFoundException("Book Not found : "+bookId);
		
		bookService.deleteById(bookId);
		
		return "Deleted Book id : "+bookId;
	}
	
	
	
	
}
