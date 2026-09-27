package kz.bitlab.g128sprinttask61.service;

import java.util.List;
import kz.bitlab.g128sprinttask61.entity.Author;
import kz.bitlab.g128sprinttask61.entity.Book;
import kz.bitlab.g128sprinttask61.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookService bookService;

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public Author getAuthorById(Long id) {
    if (id == null || id <= 0) {
      return null;
    }

    return authorRepository.findById(id).orElse(null);
  }

  public void addBook(Long bookId, Long authorId) {
    Book book = bookService.getBookById(bookId);
    Author author = getAuthorById(authorId);
    author.getBooks().add(book);
    authorRepository.save(author);
  }

  public void deleteBook(Long bookId, Long authorId) {
    Book book = bookService.getBookById(bookId);
    Author author = getAuthorById(authorId);
    author.getBooks().remove(book);
    authorRepository.save(author);
  }
}
