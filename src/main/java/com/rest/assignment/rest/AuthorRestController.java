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

import com.rest.assignment.entity.Author;
import com.rest.assignment.entity.Book;
import com.rest.assignment.service.AuthorService;
import com.rest.assignment.service.BookService;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
	
	@Autowired 
	private AuthorService authorService;
	
	@Autowired 
	private BookService bookService;
	
	@GetMapping("/")
	public List<Author> getBooks(){
		return authorService.findAll();
	}
	
	@GetMapping("/{authorId}")
	public Author getAuthor(@PathVariable int authorId) {
		Author author = authorService.findById(authorId);
		
		return author;
	}
	
	
	@PutMapping("/")
	public Author updateAuthor(@RequestBody Author theAuthor) {
		authorService.save(theAuthor);
		return theAuthor;
	}
	
	@DeleteMapping("/{authorId}")
	public String deleteAuthor(@PathVariable int authorId) {
		Author theAuthor = authorService.findById(authorId);
		
		authorService.deleteById(authorId);
		return "Deleted Author id: "+authorId;
	}
	
	@GetMapping("/{authorId}/books")
	public List<Book> getAuthorBooks(@PathVariable int authorId){
		Author author= authorService.findById(authorId);
		return author.getBooks();
	}
	

}
