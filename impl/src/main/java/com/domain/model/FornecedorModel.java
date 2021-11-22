package com.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
@Document(value = "Fornecedor")
public class FornecedorModel {

    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private DepartamentoEnum departamentoEnum;
    private String email;
    private String telefone;
    private String endereco;
    private FornecimentoStatusEnum fornecimentoStatusEnum;
    private List<ItemModel> listaItens = new ArrayList<>();
}