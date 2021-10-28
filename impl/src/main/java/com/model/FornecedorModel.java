package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "Fornecedor")
public class FornecedorModel {

    @Id
    private String id;
    @Indexed(unique = true)
    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private DepartamentoEnum departamentoEnum;
    private String email;
    private String telefone;
    private String endereco;
    private boolean fornecedorAtivo;
    private List<ItemModel> listaItens = new ArrayList<>();
}