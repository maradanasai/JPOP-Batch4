package com.jpop4.controller;

import com.jpop4.domain.BookDto;
import com.jpop4.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public BookDto findBookDetails(@PathVariable BigInteger bookId) {
        return bookService.getBookDetails(bookId);
    }

    @GetMapping
    public List<BookDto> findAllBookDetails() {
        return bookService.getAllBookDetails();
    }

    @PostMapping
    public boolean addBookDetails(@RequestBody BookDto bookDto) {
        return bookService.addBookDetails(bookDto);
    }

    @DeleteMapping("/{bookId}")
    public boolean removeBookDetails(@PathVariable BigInteger userId) {
        return bookService.deleteBookDetails(userId);
    }

    @PutMapping
    public BookDto updateBookDetails(@RequestBody BookDto bookDto) {
        return bookService.updateBookDetails(bookDto);
    }
}
