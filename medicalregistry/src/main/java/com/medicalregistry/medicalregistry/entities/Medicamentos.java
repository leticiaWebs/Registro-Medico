package com.medicalregistry.medicalregistry.entities;

import com.medicalregistry.medicalregistry.enums.ReceituarioCode;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_MEDICAMENTOSCADASTRADOS")
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String NumeroCas;
    private   ReceituarioCode receituarioCode;
    private int periodo;

    public Medicamentos(){

    }

    public Medicamentos(Long id, String nome, String numeroCas, ReceituarioCode receituarioCode, int periodo) {
        Id = id;
        this.nome = nome;
        NumeroCas = numeroCas;
        this.receituarioCode = receituarioCode;
        this.periodo = periodo;
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

    public String getNumeroCas() {
        return NumeroCas;
    }

    public void setNumeroCas(String numeroCas) {
        NumeroCas = numeroCas;
    }

    public ReceituarioCode getReceituarioCode() {
        return receituarioCode;
    }

    public void setReceituarioCode(ReceituarioCode receituarioCode) {
        this.receituarioCode = receituarioCode;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}

