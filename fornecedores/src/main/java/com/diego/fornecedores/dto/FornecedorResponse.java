package com.diego.fornecedores.dto;

import com.diego.fornecedores.model.Fornecedor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record FornecedorResponse(@JsonProperty Long id,
                                 @JsonProperty String nome,
                                 @JsonProperty String cnpj,
                                 @JsonProperty LocalDateTime criadoEm) {

    public static FornecedorResponse toResponse(Fornecedor fornecedor) {
        return new FornecedorResponse(fornecedor.getId(), fornecedor.getNome(),
                fornecedor.getCnpj(), fornecedor.getCriadoEm());
    }
}
