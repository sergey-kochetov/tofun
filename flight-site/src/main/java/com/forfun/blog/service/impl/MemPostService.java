package com.forfun.blog.service.impl;

import com.forfun.blog.domain.Post;
import com.forfun.blog.dto.PostDTO;
import com.forfun.blog.service.api.IPostService;
import com.forfun.blog.service.api.StorageService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("memPostService")
public class MemPostService implements IPostService {

    private Faker faker = new Faker();
    @Autowired
    private StorageService storageService;

    private List<Post> posts = new LinkedList<>(Arrays.asList(
            Post.builder()
                    .id(0L)
                    .title(faker.lorem().fixedString(3))
                    .body(faker.lorem().sentence(30000))
                    .img("/img/1.jpg")
                    .build(),
            Post.builder()
                    .id(1L)
                    .title(faker.lorem().fixedString(3))
                    .body(faker.lorem().sentence(30000))
                    .img("/img/2.jpg")
                    .build(),
            Post.builder()
                    .id(2L)
                    .title(faker.lorem().fixedString(3))
                    .body(faker.lorem().sentence(30000))
                    .img("/img/1.jpg")
                    .build(),
            Post.builder()
                    .id(3L)
                    .title(faker.lorem().fixedString(3))
                    .body(faker.lorem().sentence(30000))
                    .img("/img/2.jpg")
                    .build()
    ));

    @Override
    public Post findById(Long id) {
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public List<Post> search(String query) {
        return query != null && !query.isEmpty() ?
                posts.stream().filter(postDTO -> isMatches(query, postDTO.getTitle()) || isMatches(query, postDTO.getBody()))
                        .collect(Collectors.toList())
                :
                posts;
    }

    private boolean isMatches(String query, String title) {
        return title.toLowerCase()
                .matches(".*" + query.toLowerCase() + ".*");
    }

    @Override
    public void save(PostDTO postDTO) throws IOException {
        String prefix = UUID.randomUUID().toString();
        String filename = prefix + postDTO.getImageFile().getOriginalFilename();
        storageService.store(postDTO.getImageFile(), prefix);
        postDTO.setId((long) posts.size());
        postDTO.setImg(filename);
        posts.add(Post.builder()
                .id((long) posts.size())
                .img(postDTO.getImg())
                .title(postDTO.getTitle())
                .body(postDTO.getBody())
                .build());

    }
}
