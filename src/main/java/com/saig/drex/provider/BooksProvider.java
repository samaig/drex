package com.saig.drex.provider;

import com.saig.drex.model.BookBestSellers;
import com.saig.drex.provider.helper.NYTimesProviderHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Service
public class BooksProvider {

    private static final String API_KEY = "?api-key=";
    private static final String BOOKS_CONTEXT = "/svc/books/v3";
    private static final String BEST_SELLERS_LIST = "/lists/names.json";

    private final WebClient webClient;
    private final NYTimesProviderHelper nyTimesProviderHelper;

    public BooksProvider(
            @Value("${provider.nytimes.url}") String nytimesBaseUrl,
            WebClient.Builder webClientBuilder,
            HttpClient httpClient,
            NYTimesProviderHelper nyTimesProviderHelper) {
        this.nyTimesProviderHelper = nyTimesProviderHelper;

        this.webClient = nyTimesProviderHelper.setWebClientBuilder(webClientBuilder, httpClient, nytimesBaseUrl);
    }

    public Mono<BookBestSellers> getBestSellers() {
        return nyTimesProviderHelper.getApiKey()
                .flatMap(apiKey -> webClient.get()
                        .uri(BOOKS_CONTEXT + BEST_SELLERS_LIST + API_KEY + apiKey)
                        .retrieve()
                        .bodyToMono(BookBestSellers.class));
    }

}
