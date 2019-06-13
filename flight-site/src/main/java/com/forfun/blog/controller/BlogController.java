package com.forfun.blog.controller;

import com.forfun.blog.domain.Post;
import com.forfun.blog.dto.PostDTO;
import com.forfun.blog.service.api.IPostService;
import com.forfun.blog.service.api.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class BlogController {

    @Autowired
    @Qualifier("dbPostService")
    private IPostService postService;
    @Autowired
    private StorageService storageService;


    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("hasErrors", false);
        model.addAttribute("postDTO", new PostDTO());
        return "postForm";
    }

    @PostMapping("/post")
    public String savePost(@Valid @ModelAttribute PostDTO postDTO,
                           BindingResult bindingResult, Model model) throws IOException {
        model.addAttribute("postDTO", postDTO);
        model.addAttribute("hasErrors", bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            return "postForm";
        }
        String mimeType = postDTO.getImageFile().getContentType();
        String type = mimeType.split("/")[0];

        if (type.equalsIgnoreCase("image")) {
           postService.save(postDTO);
            return "redirect:/search";
        }
        return "postForm";
    }

    @GetMapping("/post/{id}")
    public String post(Model model, @PathVariable Long id) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);

        return "post";
    }

    @GetMapping("/file/{filename}")
    public ResponseEntity<Resource> file(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                file.getFilename() + "\"").body(file);
    }
}
