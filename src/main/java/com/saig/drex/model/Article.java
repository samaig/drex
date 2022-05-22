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
public class Article {

    private String section;
    private String subsection;
    private String title;
    @JsonProperty("abstract")
    private String abstractValue;
    private String url;
    private String uri;
    private String byline;
    @JsonProperty("itemType")
    private String itemType;
    @JsonProperty("updatedDate")
    private String updatedDate;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("publishedDate")
    private String publishedDate;
    @JsonProperty("materialTypeFacet")
    private String material_type_facet;
    private String kicker;
    @JsonProperty("des_facet")
    private List<Object> desFacet;
    @JsonProperty("org_facet")
    private List<Object> orgFacet;
    @JsonProperty("per_facet")
    private List<Object> perFacet;
    @JsonProperty("geo_facet")
    private List<Object> geoFacet;
    private List<Object> multimedia;
    @JsonProperty("short_url")
    private String shortUrl;

}
