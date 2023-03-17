package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.print.Doc;
import java.util.List;

@Table(name = "level")
@Entity
@Data
public class Level {
    @Id
    @Column(length = 50, name = "level_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long levelId;

    @Column(name="level_name)")
    private String levelName;

    @ManyToMany(mappedBy = "topicLevels")
    private List<Topic> topics;

    @ManyToMany(mappedBy = "documentLevels")
    private List<Document> documents;

    @ManyToMany(mappedBy = "userLevels")
    private List<User> users;
}
