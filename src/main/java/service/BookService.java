package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.BookController;
import model.Book;

@Path("/book")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class BookService {

	private BookController bookController;

	public BookService() {
		bookController = new BookController();
	}

	@GET
	@Path("/list")
	public Response getAListOfBooks() {
		try {
			List<Book> books = new ArrayList<Book>();
			books = bookController.getAllBooks();
			
			if (!books.isEmpty()) {
				return Response.status(200).entity(books).build();
			} else {
				return Response.status(204).build();
			}
		} catch (Exception e) {
			return Response.status(500).entity("{\"message\": \"error ao tentar listar cidadaos\"}").build();
		}
	}

}
