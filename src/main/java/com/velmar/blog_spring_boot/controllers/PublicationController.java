package com.velmar.blog_spring_boot.controllers;

import com.velmar.blog_spring_boot.dto.PublicationDTO;
import com.velmar.blog_spring_boot.services.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    IPublicationService service;

    @PostMapping()
    public ResponseEntity<PublicationDTO> savePublication(@RequestBody PublicationDTO publicationDTO){
        return new ResponseEntity<>(service.createPublication(publicationDTO), HttpStatus.CREATED);
    }
    @GetMapping()
    public List<PublicationDTO> getAllPublications(){
        return service.getAllPublications();
    }
    @GetMapping("{id}")
    public ResponseEntity<PublicationDTO> getPublicationById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPublication(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<PublicationDTO> updatePublication(@RequestBody PublicationDTO publication, @PathVariable Long id){
        return ResponseEntity.ok(service.updatePublication(publication,id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePublication(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteUpdate(id));
    }
}
