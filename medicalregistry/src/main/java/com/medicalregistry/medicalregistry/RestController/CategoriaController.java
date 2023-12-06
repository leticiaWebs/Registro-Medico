package com.medicalregistry.medicalregistry.RestController;


import com.medicalregistry.medicalregistry.entities.Categorias;
import com.medicalregistry.medicalregistry.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categoriasapp")
public class CategoriaController {

    @Autowired
    private CategoriasService service;
    @GetMapping
    public ResponseEntity<List<Categorias>> findAll(){
        List<Categorias> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
