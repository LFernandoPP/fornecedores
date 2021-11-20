package com.facade;

import com.model.FornecedorModel;
import com.model.FornecimentoStatusEnum;
import com.service.FornecedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FornecedorFacade {

    private FornecedorService service;

    public FornecedorModel cadastra(FornecedorModel fornecedor) {
        return service.cadastra(fornecedor);
    }

    public FornecedorModel buscaCnpj(String cnpj) {
        return service.buscaCnpj(cnpj);
    }

    public String alteraStatus(String cnpj, FornecimentoStatusEnum novoStatus) {
        return service.alteraStatus(cnpj, novoStatus);
    }
}