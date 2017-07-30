package controller;

import java.util.ArrayList;
import java.util.List;

import dao.BookDAO;
import model.Book;

public class BookController {
	private BookDAO bookDAO;

	public BookController() {
		bookDAO = new BookDAO();
	}

	public boolean registerBook(Book book) {
		try {
			bookDAO.saveOrUpdate(book);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<Book>();
		try {
			books = bookDAO.listAll();
		} catch (Exception e) {
			
		}
		return books;
	}
}
