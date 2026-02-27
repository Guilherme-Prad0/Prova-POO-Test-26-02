package com.zera.estudante.controllers;

import com.zera.estudante.models.EstudanteModel;
import com.zera.estudante.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping
    public EstudanteModel criarEstudante(EstudanteModel estudanteModel){
        return estudanteService.criarEstudante(estudanteModel);
    }

    @GetMapping
    public List<EstudanteModel> buscarTodosEstudantes(){
        return estudanteService.buscarTodosEstudantes();
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id ){
        estudanteService.deletarEstudante(id);
    }




}
