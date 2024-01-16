package com.medicalregistry.medicalregistry.DTO;


import com.medicalregistry.medicalregistry.entities.Pacientes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PacientesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private String cpf;

    public PacientesDTO() {

    }

    public PacientesDTO(Long id, String nome, String email, String cpf) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public PacientesDTO(Pacientes pacientes) {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
