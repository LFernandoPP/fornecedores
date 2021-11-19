package com.v1.dto.request;

import com.model.DepartamentoEnum;
import com.model.FornecimentoStatusEnum;
import com.model.ItemModel;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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
    private String email;
    private String telefone;
    private String endereco;
    private FornecimentoStatusEnum fornecimentoStatusEnum;
    private List<ItemModel> listaItens = new ArrayList<>();
}