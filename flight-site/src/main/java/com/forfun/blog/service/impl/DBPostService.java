package com.forfun.blog.service.impl;

import com.forfun.blog.domain.Post;
import com.forfun.blog.dto.PostDTO;
import com.forfun.blog.exception.PageNotFoundException;
import com.forfun.blog.jpa.PostRepository;
import com.forfun.blog.service.api.IPostService;
import com.forfun.blog.service.api.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("dbPostService")
public class DBPostService implements IPostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private StorageService storageService;

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(PageNotFoundException::new);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> search(String query) {
        String searchText = "%" + query + "%";
        return query != null && !query.isEmpty() ?
                postRepository.findAllByTitleLikeOrBodyLike(searchText, searchText)
                :
                postRepository.findAll();
    }

    @Override
    public void save(PostDTO postDTO) {
        String filename = postDTO.getImg();
        if (postDTO.getImageFile() != null) {
            String prefix = UUID.randomUUID().toString();
            filename = "/file" + prefix + postDTO.getImageFile().getOriginalFilename();
            storageService.store(postDTO.getImageFile(), prefix);
        }

        postDTO.setImg(filename);
        postRepository.save(Post.builder()
                .img(postDTO.getImg())
                .title(postDTO.getTitle())
                .body(postDTO.getBody())
                .build());
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public void deleteAll() {
        postRepository.deleteAll();
    }
}
