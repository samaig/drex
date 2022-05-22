package com.saig.drex.service;

import com.saig.drex.model.BookBestSellers;
import com.saig.drex.provider.BooksProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BooksProvider booksProvider;

    public Mono<BookBestSellers> getBestSellers() {
        return booksProvider.getBestSellers();
    }
}
