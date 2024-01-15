package com.medicalregistry.medicalregistry.repositories;

import com.medicalregistry.medicalregistry.entities.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface medicosRepository extends JpaRepository<Medicos, Long>{

}
