package com.v1.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemRequest {

    @NotBlank
    private String cnpj;
    private String nomeFantasia;
    private String item;
    private String tempoDeValidade;
    private int valor;
}