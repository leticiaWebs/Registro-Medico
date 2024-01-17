package com.medicalregistry.medicalregistry.RestController;


import com.medicalregistry.medicalregistry.DTO.MedicosDTO;
import com.medicalregistry.medicalregistry.DTO.PacientesDTO;
import com.medicalregistry.medicalregistry.services.MedicosService;
import com.medicalregistry.medicalregistry.services.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categoriapaciente")
public class PacienteController {

    @Autowired
    private PacientesService service;

    @GetMapping
    public ResponseEntity<List<PacientesDTO>> findAll(){
        List<PacientesDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PacientesDTO> findById(@PathVariable Long id){
        PacientesDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<PacientesDTO> insert (@RequestBody PacientesDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<PacientesDTO> update (@PathVariable Long id, @RequestBody PacientesDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

}


