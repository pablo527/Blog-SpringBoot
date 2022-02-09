package com.velmar.blog_spring_boot.repositories;

import com.velmar.blog_spring_boot.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication,Long> {
}
