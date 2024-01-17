package com.medicalregistry.medicalregistry.entities;


import jakarta.persistence.*;

import java.util.regex.Pattern;

@Entity
@Table(name  = "TB_PACIENTESCADASTRADOS" )
public class Pacientes {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
     private String nome;
     private String email;
     private String cpf;


    public Pacientes() {

    }

    public Pacientes(Long id, String nome, String email, String cpf) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
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


    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean validarEmail(String email) {
            return Pattern.matches(".+@.+\\..+", email);
        }


}
