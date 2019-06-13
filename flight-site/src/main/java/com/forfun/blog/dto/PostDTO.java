package com.forfun.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO implements Serializable {

    private Long id;

    @NotBlank(message = "msg")
    private String title;
    private String body;
    private String img;
    @NotNull
    private MultipartFile imageFile;
}
