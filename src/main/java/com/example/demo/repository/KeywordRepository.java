package com.example.demo.repository;

import com.example.demo.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Key;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    boolean existsKeywordByTerm(String term);

    Keyword findKeywordByTerm(String term);
}
