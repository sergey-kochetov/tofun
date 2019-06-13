package com.forfun.blog.controller;

import com.forfun.blog.domain.Post;
import com.forfun.blog.dto.PostDTO;
import com.forfun.blog.service.impl.DBPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiBlogController {
    @Autowired
    private DBPostService postService;

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        System.out.println("Get post id " + id);
        return ResponseEntity.ok(postService.findById(id));
    }

    @GetMapping("/post")
    public List<Post> posts(@RequestParam(value = "query", required = false) String query) {
        System.out.println("Get posts");
        return postService.search(query);
    }

    @PostMapping("/post")
    public ResponseEntity<Post> post(@RequestBody PostDTO postDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ResponseEntity.badRequest();
        }
        postService.save(postDTO);
        System.out.println("Post");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/post/{id}")
    public void deleteById(@PathVariable Long id) {
        postService.delete(id);
        System.out.println("DEL " + id);
    }

    @DeleteMapping("/post")
    public void deleteAll() {
        postService.deleteAll();
        System.out.println("DEL ALL");
    }
}
