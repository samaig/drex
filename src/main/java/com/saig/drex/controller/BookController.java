package com.saig.drex.controller;

import com.saig.drex.model.BookBestSellers;
import com.saig.drex.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/nytimes/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/best-sellers")
    public Mono<BookBestSellers> getBestSeller() {
        return bookService.getBestSellers();
    }

}
