package com.saig.drex.controller;

import com.saig.drex.model.TopStories;
import com.saig.drex.service.TopStoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/nytimes/top-stories")
@RequiredArgsConstructor
public class TopStoriesController {

    private final TopStoriesService topStoriesService;

    @GetMapping("/section")
    public Mono<TopStories> getBestSeller(@RequestParam String section) {
        return topStoriesService.getSection(section);
    }

}
