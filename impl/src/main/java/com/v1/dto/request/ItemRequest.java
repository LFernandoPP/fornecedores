package com.v1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemRequest {

    @CNPJ
    private String cnpj;

    @NotNull(message = "Campo obrigatório")
    @Size(min = 3, max = 100, message = "Min 3, Max 100")
    private String nomeFantasia;

    @NotNull(message = "Campo obrigatório")
    @Size(min = 3, max = 100, message = "Min 3, Max 100")
    private String item;

    @NotNull(message = "Campo obrigatório")
    private String tempoDeValidade;

    @NotNull(message = "Campo obrigatório")
    @PositiveOrZero
    private int valor;
}