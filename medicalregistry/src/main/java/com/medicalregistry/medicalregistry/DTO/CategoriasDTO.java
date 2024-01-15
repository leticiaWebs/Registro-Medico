package com.medicalregistry.medicalregistry.DTO;

import com.medicalregistry.medicalregistry.entities.Categorias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class CategoriasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String nome;

    public CategoriasDTO(){

    }


    public CategoriasDTO(Long Id, String nome){
        super();
        this.id =id;
        this.nome = nome;
    }
    public CategoriasDTO(Categorias entity){
        this.id = entity.getId();
        this.nome = entity.getNomecategoria();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
