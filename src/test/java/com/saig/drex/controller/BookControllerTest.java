package com.saig.drex.controller;

import com.saig.drex.model.BookBestSellers;
import com.saig.drex.model.Result;
import com.saig.drex.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(BookController.class)
@Import(BookService.class)
class BookControllerTest {

    private final List<Result> results = Collections.emptyList();

    private static final String STATUS = "OK";
    private static final String COPYRIGHT = "(c) 2022. All Rights Reserved.";
    public static final int NUMBER_OF_RESULTS = 59;

    @MockBean
    BookService bookService;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        when(bookService.getBestSellers()).thenReturn(getBestSellers());
    }

    @Test
    void testBestSeller() {
        webTestClient.get()
                .uri("/api/v1/nytimes/book/best-sellers")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo(STATUS)
                .jsonPath("$.copyright").isEqualTo(COPYRIGHT)
                .jsonPath("$.num_results").isEqualTo(NUMBER_OF_RESULTS)
                .jsonPath("$.results").isArray()
                .jsonPath("$.results").isEmpty();

        verify(bookService, times(1)).getBestSellers();
    }

    @Test
    void testBestSeller_throwsException() {
        webTestClient.get()
                .uri("/api/v1/nytimes/book/best-sellers")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo(STATUS)
                .jsonPath("$.copyright").isEqualTo(COPYRIGHT)
                .jsonPath("$.num_results").isEqualTo(NUMBER_OF_RESULTS)
                .jsonPath("$.results").isArray()
                .jsonPath("$.results").isEmpty();

        verify(bookService, times(1)).getBestSellers();
    }

    private Mono<BookBestSellers> getBestSellers() {
        return Mono.just(BookBestSellers.builder()
                .status(STATUS)
                .copyright(COPYRIGHT)
                .numResults(NUMBER_OF_RESULTS)
                .results(results)
                .build());
    }
}