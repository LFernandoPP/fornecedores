package com.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(value = "Fornecedor")
public class FornecedorModel {

    @Indexed(unique = true)
    private String cnpj;

    private String nomeFantasia;
    private String razaoSocial;
    private DepartamentoEnum departamentoEnum;
    @Email
    private String email;
    private String telefone;
    private String endereco;
    private FornecimentoStatusEnum fornecimentoStatusEnum;
    private List<ItemModel> listaItens = new ArrayList<>();
}