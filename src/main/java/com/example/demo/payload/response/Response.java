package com.example.demo.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    @JsonProperty("statusCode")
    private int statusCode;

    @JsonProperty("message")
    private String message;
}
