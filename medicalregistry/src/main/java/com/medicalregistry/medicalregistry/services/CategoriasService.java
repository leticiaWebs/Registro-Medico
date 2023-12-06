package com.medicalregistry.medicalregistry.services;


import com.medicalregistry.medicalregistry.entities.Categorias;
import com.medicalregistry.medicalregistry.repositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository repository;
    public List<Categorias> findAll() {
        return repository.findAll();
    }


}
