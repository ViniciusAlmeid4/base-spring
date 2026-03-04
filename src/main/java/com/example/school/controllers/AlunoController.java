package com.example.school.controllers;

import com.example.school.models.AlunoModel;
import com.example.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoModel criarAluno(@RequestBody AlunoModel alunoModel) {
        return alunoService.criarAluno(alunoModel);
    }

    @GetMapping
    public List<AlunoModel> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping(path = "/{id}")
    public Optional<AlunoModel> listarAluno(@PathVariable Long id) {
        return alunoService.listarAluno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public AlunoModel updateAluno(@PathVariable Long id, @RequestBody AlunoModel alunoModel) {
        return alunoService.editarAluno(id, alunoModel);
    }
}
