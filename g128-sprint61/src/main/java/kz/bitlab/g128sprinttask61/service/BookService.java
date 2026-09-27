package kz.bitlab.g128sprinttask61.service;

import java.util.List;
import kz.bitlab.g128sprinttask61.entity.Book;
import kz.bitlab.g128sprinttask61.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book getBookById(Long id) {
    if (id == null || id <= 0) {
      return null;
    }

    return bookRepository.findById(id).orElse(null);
  }
}
