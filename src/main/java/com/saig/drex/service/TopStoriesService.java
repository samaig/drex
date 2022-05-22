package com.saig.drex.service;

import com.saig.drex.model.TopStories;
import com.saig.drex.model.TopStoriesSection;
import com.saig.drex.provider.TopStoriesProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TopStoriesService {

    private final TopStoriesProvider topStoriesProvider;

    public Mono<TopStories> getSection(String section) {
        return topStoriesProvider.getSection(TopStoriesSection.fromSection(section));
    }
}
