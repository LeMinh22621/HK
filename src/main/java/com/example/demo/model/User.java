package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Table(name = "user")
@Entity
@Data
@Getter
@Setter
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "url_avatar")
    private String urlAvatar;

    @ManyToMany
    @JoinTable(name = "user_level", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "level_id"))
    private List<Level> userLevels;

    @ManyToMany
    @JoinTable(name = "user_topic", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private List<Topic> userTopics;

    @ManyToMany
    @JoinTable(name = "user_keyword", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private List<Keyword> userKeywords;
}