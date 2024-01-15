package com.medicalregistry.medicalregistry.RestController;


import com.medicalregistry.medicalregistry.DTO.CategoriasDTO;
import com.medicalregistry.medicalregistry.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categoriasapp")
public class CategoriaController {

    @Autowired
    private CategoriasService service;
    @GetMapping
    public ResponseEntity<List<CategoriasDTO>> findAll(){
        List<CategoriasDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriasDTO> findById(@PathVariable Long id){
        CategoriasDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
