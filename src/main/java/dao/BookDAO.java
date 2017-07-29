package dao;

import config.HibernateDAO;
import model.Book;

public class BookDAO extends HibernateDAO<Book, Long> {

	public BookDAO() {
		super(Book.class);
	}

	public void getBook() {
		
	}

	public void getAllBooks() {
		listAll();
	}

	public void saveBook(Book book) {
		save(book);
	}

	public void updateBook(Book book) {
		saveOrUpdate(book);
	}

	public void deleteBook(Book book) {
		save(book);
	}

}
