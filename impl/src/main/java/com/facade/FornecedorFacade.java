package com.facade;

import com.model.FornecimentoStatusEnum;
import com.service.FornecedorService;
import com.v1.dto.request.FornecedorRequest;
import com.v1.dto.response.FornecedorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mapper.FornecedorMapper.mapFornecedorModelParaFornecedorResponse;
import static com.mapper.FornecedorMapper.mapFornecedorRequestParaFornecedorModel;

@AllArgsConstructor
@Service
public class FornecedorFacade {

    private FornecedorService service;

    private FornecedorResponse response;

    public FornecedorResponse cadastra(FornecedorRequest fornecedor) {
        return mapFornecedorModelParaFornecedorResponse(service.cadastra(mapFornecedorRequestParaFornecedorModel(fornecedor)));
    }

    public FornecedorResponse buscaCnpj(String cnpj) {
        return mapFornecedorModelParaFornecedorResponse(service.buscaCnpj(cnpj));
    }

    public String alteraStatus(String cnpj, FornecimentoStatusEnum novoStatus) {
        return service.alteraStatus(cnpj,novoStatus);
    }
}