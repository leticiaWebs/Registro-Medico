package com.medicalregistry.medicalregistry.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name  = "TB_MEDICOSCADASTRADOS" )
public class Medicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long CRM;
    private String nome;
    private String especialidade;
    private String telefone;
    private String endereco;


    public Medicos() {
    }

    public Medicos(Long Id, Long CRM, String nome, String especialidade, String telefone, String endereco){
        super();
        this.Id = Id;
        this.CRM = CRM;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public Long getCRM() {
        return CRM;
    }

    public void setCRM(Long CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
