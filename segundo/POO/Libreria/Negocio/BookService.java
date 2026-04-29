package Negocio;

import Datos.BookRepository;
import Datos.Book;

public class BookService {
	private final BookRepository repo;
	public BookDTO getBookById(String id) {
		final Book search = repo.findById(id);
		if (search == null) {
			return null;
		}
		final String title = search.getTitle();
		final String author = search.getAuthor();
		return new BookDTO(title, author);
	}

}
