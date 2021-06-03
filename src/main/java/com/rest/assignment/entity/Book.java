package com.rest.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="number_of_pages")
	private int numberOfPages;
	
	@Column(name="price")
	private double price;
	
	@Column(name="author")
	private String author;
	
	public Book() {
		
	}

	public Book(int id, String bookName, int numberOfPages, double price, String author) {
		this.id = id;
		this.bookName = bookName;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.author = author;
	}
	

	public Book(String bookName, int numberOfPages, double price, String author) {
		this.bookName = bookName;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", numberOfPages=" + numberOfPages + ", price=" + price
				+ ", author=" + author + "]";
	}
}
