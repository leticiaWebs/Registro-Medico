package com.medicalregistry.medicalregistry.RestController;


import com.medicalregistry.medicalregistry.entities.Categorias;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categoriasapp")
public class CategoriaController {

    @GetMapping
    public ResponseEntity<List<Categorias>> findAll(){
        List<Categorias> list = new ArrayList<>();
        list.add(new Categorias(1L, "medicos"));
        list.add(new Categorias(2L, "pacientes"));
        list.add(new Categorias(3L, "medicamentos"));
        list.add(new Categorias(3L, "consulta"));
        return ResponseEntity.ok().body(list);
    }
}
