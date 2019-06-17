package com.forfun.park.controllers.web;

import com.forfun.park.models.User;
import com.forfun.park.payloads.IssueDtoRequest;
import com.forfun.park.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("/issue")
public class IssueControllerWeb {

    @Autowired
    private IssueService service;

    @GetMapping("/user")
    public String profile(Authentication authentication, Model model, Pageable pageable) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("activeIssues", service.findActiveByUserId(user.getId(), pageable));
        return "user/profile";
    }

    @GetMapping("/seach")
    public String list(Model model, @RequestParam(required = false) String query, Pageable pageable, Authentication authentication) {
        model.addAttribute("issues", service.findAllByUser((User) authentication.getPrincipal(), pageable));
        return "issue/search";
    }

    @GetMapping
    public String post() {
        return "issue/issueForm";
    }

    @PostMapping
    public String save(IssueDtoRequest dtoRequest, MultipartFile file, Authentication authentication) throws IOException {
        String mimeTupe = file.getContentType();
        if (mimeTupe != null && mimeTupe.split("/")[0].equalsIgnoreCase("image")) {
            User user = (User) authentication.getPrincipal();
            dtoRequest.setId(null);
            dtoRequest.setUserId(user.getId());

            service.saveDto(dtoRequest, user, file);
        }
        return "redirect:/issue/search";
    }
}
