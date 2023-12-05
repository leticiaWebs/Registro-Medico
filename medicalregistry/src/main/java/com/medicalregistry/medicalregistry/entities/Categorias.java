package com.medicalregistry.medicalregistry.entities;

import java.io.Serializable;
import java.util.Objects;

public class Categorias  implements Serializable {
   private static final long serialVersionUID = 1L;

    private Long id;
    private String Nomecategoria;

    public Categorias() {

    }
    public Categorias(Long id, String Nomecategoria){
        this.id = id;
        this.Nomecategoria = Nomecategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomecategoria() {
        return Nomecategoria;
    }

    public void setNomecategoria(String nomecategoria) {
        Nomecategoria = nomecategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorias that = (Categorias) o;
        return id.equals(that.id) && Nomecategoria.equals(that.Nomecategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Nomecategoria);
    }
}
