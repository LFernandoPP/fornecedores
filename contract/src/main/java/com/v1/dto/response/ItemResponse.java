package com.v1.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemResponse {

    private String cnpj;
    private String nomeFantasia;
    private String item;
    private String tempoDeValidade;
    private int valor;
}