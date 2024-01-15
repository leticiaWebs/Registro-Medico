package com.medicalregistry.medicalregistry.DTO;


import com.medicalregistry.medicalregistry.entities.Medicos;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class MedicosDTO {

    @Id
    private Long Id;



    private Long CRM;
    private String nome;
    private String especialidade;
    private String telefone;
    private String endereco;

    public MedicosDTO() {
    }

    public MedicosDTO(Medicos entity){

    }

    public MedicosDTO(Long Id, Long CRM, String nome, String especialidade, String telefone, String endereco){
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

    public void setId(Long Id) {
        Id = Id;
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

