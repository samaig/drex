package com.saig.drex.service;

import com.saig.drex.provider.BooksProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class BookServiceTest {

    private BookService bookService;
    private BooksProvider booksProvider;


    @BeforeEach
    void setUp() {
        bookService = new BookService(booksProvider);
    }

    @Test
    void getBestSellers() {
    }
}