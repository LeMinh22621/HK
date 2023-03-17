package com.example.demo.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SearchRequest implements Serializable {
    @JsonProperty("keyword_term")
    private String keywordTerm;

    @JsonProperty("user_id")
    private Long userId;
}
