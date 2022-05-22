package com.saig.drex.controller;

import com.saig.drex.model.Article;
import com.saig.drex.model.TopStories;
import com.saig.drex.service.TopStoriesService;
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
@WebFluxTest(TopStoriesController.class)
@Import(TopStoriesService.class)
class TopStoriesControllerTest {

    private final List<Article> results = Collections.emptyList();

    private static final String STATUS = "OK";
    private static final String SECTION = "arts";
    public static final int NUMBER_OF_RESULTS = 59;
    private static final String LAST_UPDATED = "2022-05-22T02:36:01-04:00";
    private static final String COPYRIGHT = "(c) 2022. All Rights Reserved.";

    @MockBean
    TopStoriesService topStoriesService;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        when(topStoriesService.getSection(SECTION)).thenReturn(getSection());
    }

    @Test
    void testSection() {
        webTestClient.get()
                .uri("/api/v1/nytimes/top-stories/section?section=" + SECTION)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo(STATUS)
                .jsonPath("$.copyright").isEqualTo(COPYRIGHT)
                .jsonPath("$.section").isEqualTo(SECTION)
                .jsonPath("$.num_results").isEqualTo(NUMBER_OF_RESULTS)
                .jsonPath("$.last_updated").isEqualTo(LAST_UPDATED)
                .jsonPath("$.results").isArray()
                .jsonPath("$.results").isEmpty();

        verify(topStoriesService, times(1)).getSection(SECTION);
    }

    private Mono<TopStories> getSection() {
        return Mono.just(TopStories.builder()
                .status(STATUS)
                .copyright(COPYRIGHT)
                .section(SECTION)
                .numResults(NUMBER_OF_RESULTS)
                .lastUpdated(LAST_UPDATED)
                .results(results)
                .build());
    }
}