package com.medicalregistry.medicalregistry.services;

import com.medicalregistry.medicalregistry.DTO.MedicosDTO;
import com.medicalregistry.medicalregistry.entities.Medicos;
import com.medicalregistry.medicalregistry.exceptions.DataBaseException;
import com.medicalregistry.medicalregistry.exceptions.ResourceNotFoundException;
import com.medicalregistry.medicalregistry.exceptions.UnprocessableEntityException;
import com.medicalregistry.medicalregistry.repositories.medicosRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MedicosService {

   @Autowired
   private medicosRepository repository;

   @Transactional
   public List<MedicosDTO> findAll() {
       return repository.findAll().stream()
               .map(MedicosDTO::new)
               .collect(Collectors.toList());
   }

    @Transactional
    public MedicosDTO findById(Long CRM) {
        Optional<Medicos> obj = repository.findById(CRM);
        Medicos entity = obj.orElseThrow(() -> new ResourceNotFoundException("Medico não encontrado"));
        return new MedicosDTO(entity);
    }
    @Transactional
    public MedicosDTO insert(MedicosDTO dto) {
        try {
            Medicos entity = new Medicos();
            entity.setCRM(dto.getCRM());
            entity.setNome(dto.getNome());
            entity.setEspecialidade(dto.getEspecialidade());
            entity.setEndereco(dto.getEndereco());
            entity.setTelefone(dto.getTelefone());
            entity = repository.save(entity);
            return new MedicosDTO(entity);

        } catch (UnprocessableEntityException e) {
            throw new UnprocessableEntityException("CPF já existente no sistema");
        }
    }
    @Transactional
    public MedicosDTO update(Long Id, MedicosDTO dto) {
            try {
                Medicos entity = repository.getReferenceById(Id);
                entity.setNome(dto.getNome());
                entity.setEndereco(dto.getEndereco());
                entity.setTelefone(dto.getTelefone());
                entity = repository.save(entity);
                return new MedicosDTO(entity);

            }
            catch (EntityNotFoundException e) {
                throw new ResourceNotFoundException("Id not found" + Id);
            }
            catch (UnprocessableEntityException e) {
                throw new UnprocessableEntityException("CPF já existente no sistema");
            }
        }

        public void delete(Long Id) {
            try {
                repository.deleteById(Id);
            }
            catch(EmptyResultDataAccessException e) {
                throw new ResourceNotFoundException("Id not found" + Id);
            }
            catch (DataIntegrityViolationException e) {
                throw new DataBaseException("Integrity violation");
            }
            // TODO Auto-generated method stub

        }
    }





