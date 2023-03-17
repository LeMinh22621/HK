package com.example.demo.payload.response;

import com.example.demo.model.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.List;

@Data
@MappedSuperclass
public class SearchResponse extends Response{

    @JsonProperty("data")
    List<Document> documentList;
}
