package com.medicalregistry.medicalregistry.services;

import com.medicalregistry.medicalregistry.DTO.MedicosDTO;
import com.medicalregistry.medicalregistry.DTO.PacientesDTO;
import com.medicalregistry.medicalregistry.entities.Medicos;
import com.medicalregistry.medicalregistry.entities.Pacientes;
import com.medicalregistry.medicalregistry.exceptions.ResourceNotFoundException;
import com.medicalregistry.medicalregistry.repositories.pacientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PacientesService {

    @Autowired
    private pacientesRepository repository;

    @Transactional
    public List<PacientesDTO> findAll() {
        return repository.findAll().stream()
                .map(PacientesDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public PacientesDTO findById(Long Id) {
        Optional<Pacientes> obj = repository.findById(Id);
        Pacientes entity = obj.orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
        return new PacientesDTO(entity);
    }
}
