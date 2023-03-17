package com.example.demo.payload.response;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class UserResponse extends Response{
    @JsonProperty("data")
    private User user;
}
