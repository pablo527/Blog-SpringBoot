package com.velmar.blog_spring_boot.services;

import com.velmar.blog_spring_boot.dto.PublicationDTO;

import java.util.List;

public interface IPublicationService{

    PublicationDTO createPublication(PublicationDTO publication);
    List<PublicationDTO> getAllPublications(int size);
    PublicationDTO getPublication(Long id);
    PublicationDTO updatePublication(PublicationDTO publicationDTO, long id);
    String deleteUpdate(Long id);
}
