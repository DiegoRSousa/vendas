package com.diego.fornecedores.controller;

import com.diego.fornecedores.dto.FornecedorRequest;
import com.diego.fornecedores.dto.FornecedorResponse;
import com.diego.fornecedores.model.Fornecedor;
import com.diego.fornecedores.repository.FornecedorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

        List<FornecedorResponse> fornecedores = fornecedorRepository.findAll().stream().map(f ->
            new FornecedorResponse(f.getId(), f.getNome(), f.getCnpj(), f.getCriadoEm())
        ).toList();

        return ResponseEntity.ok(fornecedores);
    }

    @PostMapping
    public ResponseEntity<FornecedorResponse> salvar(@RequestBody @Valid FornecedorRequest request) {

        Fornecedor fornecedor = request.toModel();
        fornecedorRepository.save(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(FornecedorResponse.toResponse(fornecedor));
    }

}
