package com.medicalregistry.medicalregistry.repositories;

import com.medicalregistry.medicalregistry.entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

}
