package com.velmar.blog_spring_boot.services;

import com.velmar.blog_spring_boot.dto.CommentDTO;
import com.velmar.blog_spring_boot.exceptions.ResourceNotFoundException;
import com.velmar.blog_spring_boot.models.Comment;
import com.velmar.blog_spring_boot.models.Publication;
import com.velmar.blog_spring_boot.repositories.CommentRepository;
import com.velmar.blog_spring_boot.repositories.PublicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements ICommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public CommentDTO createComment(Long publicationId, CommentDTO commentDto) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id", publicationId));
        Comment comment = mapToComment(commentDto);
        comment.setPublication(publication);
        Comment newComment = commentRepository.save(comment);
        return mapToDto(newComment);
    }

    private CommentDTO mapToDto(Comment comment){
        return modelMapper.map(comment, CommentDTO.class);
    }

    private Comment mapToComment(CommentDTO commentDto){
        return modelMapper.map(commentDto, Comment.class);
    }
}
