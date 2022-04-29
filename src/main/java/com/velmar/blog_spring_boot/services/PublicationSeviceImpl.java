package com.velmar.blog_spring_boot.services;

import com.velmar.blog_spring_boot.dto.PublicationDTO;
import com.velmar.blog_spring_boot.exceptions.ResourceNotFoundException;
import com.velmar.blog_spring_boot.models.Publication;
import com.velmar.blog_spring_boot.repositories.PublicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationSeviceImpl implements IPublicationService{

    @Autowired
    PublicationRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PublicationDTO createPublication(PublicationDTO publicationDTO) {
        Publication publication = mapearEntity(publicationDTO);
        Publication newPublication = repository.save(publication);
        return mapearDto(newPublication);
    }

    @Override
    public List<PublicationDTO> getAllPublications(int size) {
        List<Publication> publications = repository.findAll();
        return publications.stream().map(this::mapearDto).collect(Collectors.toList());
    }

    @Override
    public PublicationDTO getPublication(Long id) {
        Publication publication = repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("publication", "id", id));
        return mapearDto(publication);
    }

    @Override
    public PublicationDTO updatePublication(PublicationDTO publicationDTO, long id) {
        Publication publication = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("publication","id", id));
        publication.setContent(publicationDTO.getContent());
        publication.setTitle(publicationDTO.getTitle());
        publication.setDescription(publicationDTO.getDescription());
        Publication update = repository.save(publication);
        return mapearDto(update);
    }

    @Override
    public String deleteUpdate(Long id) {
        repository.deleteById(id);
        return "Deleted completed";
    }

    private PublicationDTO mapearDto(Publication publication){
        return modelMapper.map(publication, PublicationDTO.class);
    }
    private Publication mapearEntity(PublicationDTO publicationDTO){
        return modelMapper.map(publicationDTO,Publication.class);
    }
}
