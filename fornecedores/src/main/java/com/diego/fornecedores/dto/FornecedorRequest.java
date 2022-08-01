package com.diego.fornecedores.dto;

import com.diego.fornecedores.model.Fornecedor;

import javax.validation.constraints.NotBlank;

public record FornecedorRequest(@NotBlank String nome, @NotBlank String cnpj) {
    public Fornecedor toModel() {
        return new Fornecedor(nome, cnpj);
    }
}
