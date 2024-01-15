package com.medicalregistry.medicalregistry.RestController;

import com.medicalregistry.medicalregistry.DTO.MedicosDTO;

import com.medicalregistry.medicalregistry.services.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categoriamedicos")
public class MedicoController {


    @Autowired
    private MedicosService service;

    @GetMapping
    public ResponseEntity<List<MedicosDTO>> findAll(){
        List<MedicosDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{CRM}")
    public ResponseEntity<MedicosDTO> findById(@PathVariable Long CRM){
        MedicosDTO dto = service.findById(CRM);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity<MedicosDTO> insert (@RequestBody MedicosDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @PutMapping(value = "/{Id}")
    public ResponseEntity<MedicosDTO> update (@PathVariable Long Id, @RequestBody MedicosDTO dto){
        dto = service.update(Id, dto);
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long Id){
        service.delete(Id);
        return ResponseEntity.noContent().build();

    }

}

