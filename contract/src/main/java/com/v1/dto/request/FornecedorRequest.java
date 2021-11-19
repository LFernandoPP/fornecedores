package com.v1.dto.request;

import com.model.DepartamentoEnum;
import com.model.FornecimentoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FornecedorRequest {

    @NotBlank
    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private DepartamentoEnum departamentoEnum;
    @Email
    private String email;
    private String telefone;
    private String endereco;
    private FornecimentoStatusEnum fornecimentoStatusEnum;
}