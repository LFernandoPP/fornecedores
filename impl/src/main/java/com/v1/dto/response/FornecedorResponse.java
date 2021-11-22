package com.v1.dto.response;

import com.model.DepartamentoEnum;
import com.model.FornecimentoStatusEnum;
import com.model.ItemModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FornecedorResponse {

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