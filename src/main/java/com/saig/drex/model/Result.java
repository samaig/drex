package com.saig.drex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @JsonProperty("list_name")
    private String listName;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("list_name_encoded")
    private String listNameEncoded;
    @JsonProperty("oldest_published_date")
    private String oldestPublishedDate;
    @JsonProperty("newest_published_date")
    private String newestPublishedDate;
    private String updated;

}
