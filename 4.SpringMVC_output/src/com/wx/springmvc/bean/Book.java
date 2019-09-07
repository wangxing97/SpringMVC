package com.wx.springmvc.bean;

public class Book {

	private String bookName;
	private String author;
	private double price;
	private Integer stock;
	private Integer sales;
	
	public Book() {
		super();
	}
	
	public Book(String bookName, String author, double price, Integer stock, Integer sales) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.sales = sales;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + ", price=" + price + ", stock=" + stock
				+ ", sales=" + sales ;
	}
	
	
}
