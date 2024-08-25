package com.book.bookstoreapi.service;

import com.book.bookstoreapi.dto.BookDTO;
import com.book.bookstoreapi.model.Book;
import com.book.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = mapToEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return mapToDTO(savedBook);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(bookDTO.getTitle());
                    existingBook.setAuthor(bookDTO.getAuthor());
                    existingBook.setPrice(bookDTO.getPrice());
                    existingBook.setIsbn(bookDTO.getIsbn());
                    Book updatedBook = bookRepository.save(existingBook);
                    return mapToDTO(updatedBook);
                }).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookDTO mapToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setIsbn(book.getIsbn());
        return bookDTO;
    }

    private Book mapToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setIsbn(bookDTO.getIsbn());
        return book;
    }
}
