package com.velmar.blog_spring_boot.controllers;

import com.velmar.blog_spring_boot.dto.CommentDTO;
import com.velmar.blog_spring_boot.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/publications")
public class CommentController {

    @Autowired
    ICommentService service;

    @PostMapping("/{idPublication}/comment")
    public ResponseEntity<CommentDTO> createComment(@PathVariable Long idPublication, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(service.createComment(idPublication,commentDTO), HttpStatus.CREATED);
    }

}
