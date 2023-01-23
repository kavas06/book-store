package com.js.dto;

public class Book {
		int bookid;
		private String bookname;
		private String book_authorname;
		private int noofpages;
		private double price;
		public int getBookid() {
			return bookid;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public String getBook_authorname() {
			return book_authorname;
		}
		public void setBook_authorname(String book_authorname) {
			this.book_authorname = book_authorname;
		}
		public int getNoofpages() {
			return noofpages;
		}
		public void setNoofpages(int noofpages) {
			this.noofpages = noofpages;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
	}

