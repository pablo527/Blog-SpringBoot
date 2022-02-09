package com.velmar.blog_spring_boot.services;

import com.velmar.blog_spring_boot.dto.PublicationDTO;
import com.velmar.blog_spring_boot.exceptions.ResourceNotFoundException;
import com.velmar.blog_spring_boot.models.Publication;
import com.velmar.blog_spring_boot.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements IPublicationService{
    @Autowired
    PublicationRepository repository;

    @Override
    public PublicationDTO createPublication(PublicationDTO publicationDto) {
        // Convert from DTO to Entity
        Publication publication = mapEntity(publicationDto);
        Publication newPublication = repository.save(publication);

        //Convert from entity to DTO
        return mapDto(newPublication);
    }

    @Override
    public PublicationDTO getPublication(Long id) {
        Publication publication = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publication","id",id));

        return mapDto(publication);
    }

    @Override
    public List<PublicationDTO> getAllPublications() {
        List<Publication> listPublications =repository.findAll();

        return listPublications.stream().map(this::mapDto).collect(Collectors.toList());
    }
    @Override
    public PublicationDTO updatePublication(PublicationDTO publicationDTO, long id) {
        Publication publication = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publication", "id",id));
        publication.setDescription(publicationDTO.getDescription());
        publication.setTitle(publicationDTO.getTitle());
        publication.setContent(publicationDTO.getContent());

        Publication update =  repository.save(publication);
        return mapDto(update);
    }

    @Override
    public String deleteUpdate(Long id) {
         repository.deleteById(id);
         return "Delete completed";
    }

    private Publication mapEntity(PublicationDTO publicationDTO){
        Publication publication = new Publication();
        publication.setContent(publicationDTO.getContent());
        publication.setTitle(publicationDTO.getTitle());
        publication.setDescription(publicationDTO.getDescription());
        return publication;
    }
    private PublicationDTO mapDto(Publication publication){
        PublicationDTO publicationDTO = new PublicationDTO();
        publicationDTO.setId(publication.getId());
        publicationDTO.setTitle(publication.getTitle());
        publicationDTO.setContent(publication.getContent());
        publicationDTO.setDescription(publication.getDescription());
        return publicationDTO;
    }
}
