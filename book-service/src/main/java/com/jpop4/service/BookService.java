package com.jpop4.service;

import com.jpop4.domain.BookDto;
import com.jpop4.exceptions.BookNotFoundException;
import com.jpop4.mapper.BookMapper;
import com.jpop4.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class BookService {

    private static final String BOOK_NOT_FOUND_EXCEPTION_MESSAGE = "Book details are not found with given id: ";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookDto getBookDetails(BigInteger bookId) {
        return bookMapper.toBookDto(
                bookRepository.findById(bookId)
                        .orElseThrow(() ->
                                new BookNotFoundException(BOOK_NOT_FOUND_EXCEPTION_MESSAGE + bookId))
        );
    }

    public List<BookDto> getAllBookDetails() {
        return bookMapper.toBookDtos(bookRepository.findAll());
    }

    public boolean addBookDetails(BookDto bookDto) {
        bookRepository.save(bookMapper.toBook(bookDto));
        return true;
    }

    public boolean deleteBookDetails(BigInteger bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException(BOOK_NOT_FOUND_EXCEPTION_MESSAGE + bookId);
        }

        bookRepository.deleteById(bookId);
        return true;
    }

    public BookDto updateBookDetails(BookDto bookDto) {
        if (!bookRepository.existsById(bookDto.getId())) {
            throw new BookNotFoundException(BOOK_NOT_FOUND_EXCEPTION_MESSAGE + bookDto.getId());
        }

        bookRepository.save(bookMapper.toBook(bookDto));
        return bookDto;
    }
}
