package com.v1.facade;

import com.model.FornecimentoStatusEnum;
import com.service.FornecedorService;
import com.v1.dto.request.FornecedorRequest;
import com.v1.dto.response.FornecedorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.v1.mapper.FornecedorMapper.mapFornecedorModelParaFornecedorResponse;
import static com.v1.mapper.FornecedorMapper.mapFornecedorRequestParaFornecedorModel;

@AllArgsConstructor
@Service
public class FornecedorFacade {

    private FornecedorService service;
//    ValidacaoService validacao;

    public FornecedorResponse cadastra(FornecedorRequest fornecedor) {
//        validacao.validaCnpj(fornecedor.getCnpj().replaceAll("[,/.]", ""));

        return mapFornecedorModelParaFornecedorResponse(service.cadastra(mapFornecedorRequestParaFornecedorModel(fornecedor)));
    }

    public FornecedorResponse buscaCnpj(String cnpj) {
        return mapFornecedorModelParaFornecedorResponse(service.buscaCnpj(cnpj));
    }

    public String alteraStatus(String cnpj, FornecimentoStatusEnum novoStatus) {
        return service.alteraStatus(cnpj,novoStatus);
    }
}