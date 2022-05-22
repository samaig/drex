package com.saig.drex.provider;

import com.saig.drex.model.TopStories;
import com.saig.drex.provider.helper.NYTimesProviderHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Service
public class TopStoriesProvider {

    private static final String API_KEY = "?api-key=";
    private static final String TOP_STORIES_CONTEXT = "/svc/topstories/v2/";

    private final WebClient webClient;
    private final NYTimesProviderHelper nyTimesProviderHelper;

    public TopStoriesProvider(
            @Value("${provider.nytimes.url}") String nytimesBaseUrl,
            WebClient.Builder webClientBuilder,
            HttpClient httpClient,
            NYTimesProviderHelper nyTimesProviderHelper) {
        this.nyTimesProviderHelper = nyTimesProviderHelper;

        this.webClient = nyTimesProviderHelper.setWebClientBuilder(webClientBuilder, httpClient, nytimesBaseUrl);
    }

    public Mono<TopStories> getSection(String section) {
        return nyTimesProviderHelper.getApiKey()
                .flatMap(apiKey -> webClient.get()
                        .uri(TOP_STORIES_CONTEXT + section + API_KEY + apiKey)
                        .retrieve()
                        .bodyToMono(TopStories.class));
    }

}
