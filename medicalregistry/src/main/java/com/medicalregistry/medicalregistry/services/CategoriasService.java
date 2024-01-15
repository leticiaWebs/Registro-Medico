package com.medicalregistry.medicalregistry.services;


import com.medicalregistry.medicalregistry.DTO.CategoriasDTO;
import com.medicalregistry.medicalregistry.entities.Categorias;
import com.medicalregistry.medicalregistry.repositories.CategoriasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriasService {


    @Autowired
    private CategoriasRepository repository;

    @Transactional
    public List<CategoriasDTO> findAll() {
        List<Categorias> list = repository.findAll();
        return list.stream().map(x -> new CategoriasDTO(x)).collect(Collectors.toList());

    }

    @Transactional
    public CategoriasDTO findById(Long id) {
        Optional<Categorias> obj  = repository.findById(id);
        Categorias entity = obj.get();
        return new CategoriasDTO(entity);
    }

}
