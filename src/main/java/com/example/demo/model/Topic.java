package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "topic")
@Entity
@Data
public class Topic {
    @Id
    @Column(length = 50, name = "topic_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long topicId;

    @Column(name="topic_name")
    private String topicName;

    @ManyToMany
    @JoinTable(name = "topic_level", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "level_id"))
    private List<Level> topicLevels;

    @ManyToMany
    @JoinTable(name = "topic_document", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "document_id"))
    private List<Document> topicDocuments;
}
