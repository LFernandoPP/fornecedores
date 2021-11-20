package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemModel {

    @NotEmpty
    private String cnpj;
    private String nomeFantasia;
    private String item;
    private String tempoDeValidade;
    private int valor;
}