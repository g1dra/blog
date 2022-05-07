package com.g1dra.blog.controller;

import com.g1dra.blog.model.Blog;
import com.g1dra.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public ResponseEntity<List<Blog>> blogs() {
        return new ResponseEntity<>(blogRepository.findAll(), HttpStatus.OK);
    }
}
