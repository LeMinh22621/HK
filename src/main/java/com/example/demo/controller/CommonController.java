package com.example.demo.controller;

import com.example.demo.model.Document;
import com.example.demo.model.Keyword;
import com.example.demo.model.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SearchRequest;
import com.example.demo.payload.request.UserRequest;
import com.example.demo.payload.response.Response;
import com.example.demo.payload.response.SearchResponse;
import com.example.demo.payload.response.UserResponse;
import com.example.demo.service.KeywordService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private UserService userService;

    @Autowired
    private KeywordService keywordService;

    @Autowired
    private DocumentService documentService;

    @PostMapping("/login")
    public Response login(@RequestBody LoginRequest loginRequest)
    {
        UserResponse response = new UserResponse();
        try{

            User user = userService.findUserByEmailAndPassword(loginRequest);
            if(user != null)
            {
                response.setUser(user);
                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage("Login Success");

                return response;
            }
            else {
                response.setUser(null);
                response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
                response.setMessage("Login Failed " + HttpStatus.UNAUTHORIZED);
                return response;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        response.setUser(null);
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("Login Failed " + HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;
    }

    @PostMapping("/signup")
    public Response login(@RequestBody UserRequest userRequest)
    {
        Response response = new Response();
        if(userService.findUserByEmail(userRequest.getEmail()) == null)
        {
            User user = new User();

            user.setUserId(generateUniqueId());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            user.setLastName(userRequest.getLastName());
            user.setFirstName(userRequest.getFirstName());
            user.setUrlAvatar(userRequest.getUrlAvatar());

            try{
                userService.save(user);
                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage("Signup Success " + HttpStatus.OK.name());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setMessage("Signup failed " + HttpStatus.INTERNAL_SERVER_ERROR.name());
            }
        }
        else {
            response.setStatusCode(HttpStatus.CONFLICT.value());
            response.setMessage("Had account " + HttpStatus.CONFLICT.name());
        }
        return response;
    }

    @RequestMapping(value="search", method = RequestMethod.GET)
    public Response search(@RequestBody SearchRequest searchRequest)
    {
        SearchResponse response = new SearchResponse();

        if(searchRequest != null)
        {
            Long keywordId = generateUniqueId();

            // If don't have the keyword
            if(!keywordService.existsKeywordByTerm(searchRequest.getKeywordTerm()))
            {
                //save keyword to db
                Keyword keyword = new Keyword();
                keyword.setKeyWordId(keywordId);
                keyword.setTerm(searchRequest.getKeywordTerm());

                keywordService.save(keyword);
                response.setDocumentList(null);
                response.setStatusCode(HttpStatus.NOT_FOUND.value());
                response.setMessage("No define found for this term");
            }
            else {
                //Find documents base on term
                Keyword keyword = keywordService.getKeyword(searchRequest.getKeywordTerm());
                List<Document> documents = keyword.getDocuments();

                for(Document document : documents)
                {
                    DocumentService
                }
                response.setDocumentList(documents);
                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.name());
            }
        }
        else {
            response.setDocumentList(null);
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("empty search " + HttpStatus.INTERNAL_SERVER_ERROR.name());
        }

        return response;
    }

    private long generateUniqueId() {
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Long.parseLong(str);
    }
}
