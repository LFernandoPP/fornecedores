package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemModel {

    private String cnpj;
    private String nomeFantasia;
    private String item;
    private String tempoDeValidade;
    private int valor;
}