package com.zera.estudante.controllers;

import com.zera.estudante.models.EstudanteModel;
import com.zera.estudante.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping
    public ResponseEntity<EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel){
        EstudanteModel request = estudanteService.criarEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(estudanteModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll(){
        List<EstudanteModel> request = estudanteService.buscarTodosEstudantes();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        estudanteService.deletarEstudante(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public EstudanteModel buscarPorID(@PathVariable Long id) {
        return estudanteService.buscarPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteModel> atualizarEstudante(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel){
        return estudanteService.atualizarEstudante(id, estudanteModel);


    }






}
