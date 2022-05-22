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
public class BookBestSellers {

    private String status;
    private String copyright;
    @JsonProperty("num_results")
    private int numResults;
    private List<Result> results;

}
