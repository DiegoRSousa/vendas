package com.diego.fornecedores.controller;

import com.diego.fornecedores.dto.FornecedorResponse;
import com.diego.fornecedores.repository.FornecedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorController(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponse>> listar(){

        var fornecedores = fornecedorRepository.findAll().stream().map(f ->
            new FornecedorResponse(f.getId(), f.getNome(), f.getCnpj(), f.getCriadoEm())
        ).toList();

        return ResponseEntity.ok(fornecedores);
    }
}
