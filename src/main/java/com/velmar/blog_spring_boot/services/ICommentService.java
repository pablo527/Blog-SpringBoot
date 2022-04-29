package com.velmar.blog_spring_boot.services;

import com.velmar.blog_spring_boot.dto.CommentDTO;

public interface ICommentService {
    CommentDTO createComment(Long publicationId, CommentDTO commentDto);
}
