package controller;

import dao.BookDAO;
import model.Book;

public class BookController {
	private BookDAO bookDAO;

	public BookController() {
		bookDAO = new BookDAO();
	}
	
	public boolean registerBook(Book book){
		return true;
	}
}
