package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Table(name = "document")
@Entity
@Data
@Getter
@Setter
public class Document {
    @Id
    @Column(length = 50, name = "document_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long documentId;

    @Column(name = "link")
    private String link;

    @Column(name = "header")
    private String header;

    @ManyToMany
    @JoinTable(name = "document_level", joinColumns = @JoinColumn(name = "document_id"), inverseJoinColumns = @JoinColumn(name = "level_id"))
    private List<Level> documentLevels;

    @ManyToMany
    @JoinTable(name = "document_keyword", joinColumns = @JoinColumn(name = "document_id"), inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private List<Keyword> documentKeywords;

    @ManyToMany(mappedBy = "topicDocuments")
    private List<Topic> topics;
}
