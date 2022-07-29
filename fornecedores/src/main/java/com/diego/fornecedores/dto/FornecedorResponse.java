package com.diego.fornecedores.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record FornecedorResponse(@JsonProperty Long id,
                                 @JsonProperty String name,
                                 @JsonProperty String cnpj,
                                 @JsonProperty LocalDateTime criadoEm) {
}
