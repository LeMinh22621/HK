package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "keyword")
@Entity
@Data
@Getter
@Setter
public class Keyword {

    @Id
    @Column(length = 50, name = "keyword_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long keyWordId;

    @Column(name = "term")
    private String term;

    @Column(name = "term_define")
    private String termDefine;

    @ManyToMany(mappedBy = "documentKeywords")
    private List<Document> documents;

    @ManyToMany(mappedBy = "userKeywords")
    private List<User> users;
}
