package com.example.demo.service;

import com.example.demo.model.Document;
import com.example.demo.model.Keyword;
import com.example.demo.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    public boolean existsKeywordByTerm(String term)
    {
        return keywordRepository.existsKeywordByTerm(term);
    }

    public Keyword getKeyword(String term)
    {
        return keywordRepository.findKeywordByTerm(term);
    }

    public Keyword save(Keyword keyword) {
        return keywordRepository.save(keyword);
    }
}
