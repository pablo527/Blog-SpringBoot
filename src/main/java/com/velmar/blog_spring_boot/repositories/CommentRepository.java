package com.velmar.blog_spring_boot.repositories;

import com.velmar.blog_spring_boot.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
