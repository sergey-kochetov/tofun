package com.forfun.blog.service.api;

import com.forfun.blog.domain.Post;
import com.forfun.blog.dto.PostDTO;

import java.io.IOException;
import java.util.List;

public interface IPostService {

    Post findById(Long id);

    Post save(Post post);

    List<Post> search(String query);

    void save(PostDTO postDTO) throws IOException;
}
