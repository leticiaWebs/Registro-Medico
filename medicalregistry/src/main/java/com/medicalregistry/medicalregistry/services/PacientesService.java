package com.medicalregistry.medicalregistry.services;

import com.medicalregistry.medicalregistry.DTO.MedicosDTO;
import com.medicalregistry.medicalregistry.DTO.PacientesDTO;
import com.medicalregistry.medicalregistry.entities.Medicos;
import com.medicalregistry.medicalregistry.entities.Pacientes;
import com.medicalregistry.medicalregistry.exceptions.DataBaseException;
import com.medicalregistry.medicalregistry.exceptions.ResourceNotFoundException;
import com.medicalregistry.medicalregistry.exceptions.UnprocessableEntityException;
import com.medicalregistry.medicalregistry.repositories.pacientesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

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

    @Transactional
    public PacientesDTO insert(PacientesDTO dto) {
        try {
            Pacientes entity = new Pacientes();
            entity.setNome(dto.getNome());
            entity.setEmail(dto.getEmail());
            entity.setCpf(dto.getCpf());
            return new PacientesDTO(entity);

        } catch (UnprocessableEntityException e) {
            throw new UnprocessableEntityException("CPF já existente no sistema");
        }


    }

    @Transactional
    public PacientesDTO update(Long Id, PacientesDTO dto) {
        try {
            Pacientes entity = repository.getReferenceById(Id);
            entity.setNome(dto.getNome());
            entity.setEmail(dto.getEmail());
            entity.setCpf(dto.getCpf());
            entity = repository.save(entity);
            return new PacientesDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found" + Id);
        } catch (UnprocessableEntityException e) {
            throw new UnprocessableEntityException("CPF já existente no sistema");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
        // TODO Auto-generated method stub


    }
}
