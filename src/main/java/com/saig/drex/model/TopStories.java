package com.saig.drex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopStories {

    private String status;
    private String copyright;
    private String section;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("num_results")
    private int numResults;
    private List<Article> results;

}
