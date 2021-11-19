package com.v1.mapper;

import com.model.FornecedorModel;
import com.v1.dto.request.FornecedorRequest;
import com.v1.dto.response.FornecedorResponse;

public class FornecedorMapper {

    public static FornecedorModel mapFornecedorRequestParaFornecedorModel(FornecedorRequest fornecedor) {
        return FornecedorModel
                .builder()
                .cnpj(fornecedor.getCnpj())
                .nomeFantasia(fornecedor.getNomeFantasia())
                .razaoSocial(fornecedor.getRazaoSocial())
                .departamentoEnum(fornecedor.getDepartamentoEnum())
                .email(fornecedor.getEmail())
                .telefone(fornecedor.getTelefone())
                .endereco(fornecedor.getEndereco())
                .fornecimentoStatusEnum(fornecedor.getFornecimentoStatusEnum())
                .listaItens(fornecedor.getListaItens())
                .build();
    }

    public static FornecedorResponse mapFornecedorModelParaFornecedorResponse(FornecedorModel fornecedor) {
        return FornecedorResponse
                .builder()
                .cnpj(fornecedor.getCnpj())
                .nomeFantasia(fornecedor.getNomeFantasia())
                .razaoSocial(fornecedor.getRazaoSocial())
                .departamentoEnum(fornecedor.getDepartamentoEnum())
                .email(fornecedor.getEmail())
                .telefone(fornecedor.getTelefone())
                .endereco(fornecedor.getEndereco())
                .fornecimentoStatusEnum(fornecedor.getFornecimentoStatusEnum())
                .listaItens(fornecedor.getListaItens())
                .build();
    }
}