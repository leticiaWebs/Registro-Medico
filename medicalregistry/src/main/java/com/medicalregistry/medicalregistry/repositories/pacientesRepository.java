package com.medicalregistry.medicalregistry.repositories;

import com.medicalregistry.medicalregistry.entities.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface pacientesRepository extends JpaRepository<Pacientes, Long> {


}
