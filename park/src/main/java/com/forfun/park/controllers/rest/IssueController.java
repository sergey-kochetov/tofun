package com.forfun.park.controllers.rest;

import com.forfun.park.models.User;
import com.forfun.park.payloads.IssueDtoRequest;
import com.forfun.park.payloads.IssueDtoResponse;
import com.forfun.park.service.IssueService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

@RestController
@RequestMapping("/api/issue")
public class IssueController {
    @Autowired
    private IssueService service;

    @PostMapping
    public void save(IssueDtoRequest dtoRequest, MultipartFile file, @ApiIgnore Authentication authentication) throws IOException {
        String mimeType = file.getContentType();
        if (mimeType != null && mimeType.split("/")[0].equals("image")) {
            User user = (User) authentication.getPrincipal();
            dtoRequest.setId(null);
            dtoRequest.setUserId(user.getId());

            service.saveDto(dtoRequest, user, file);
        }
    }

    @ApiOperation(value = "Список операций")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page.")
    })
    @GetMapping
    public Page<IssueDtoResponse> getAll(@ApiIgnore Authentication authentication, @ApiIgnore Pageable pageable){
        User user = (User) authentication.getPrincipal();

        return service.findAllByUser(user, pageable);
    }
}
