package com.service;

import com.model.FornecedorModel;
import com.model.FornecimentoStatusEnum;
import com.repository.CnpjRepository;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FornecedorService {

    private CnpjRepository cnpjRepository;
    private FornecedorRepository fornecedorRepository;
//    private ValidacaoService valida;

    public FornecedorModel cadastra(FornecedorModel fornecedor) {
        cnpjRepository.cnpjStatus(fornecedor.getCnpj());
//        valida.validaCnpjRegistrado(fornecedor.getCnpj());

        return fornecedorRepository.insert(fornecedor);
    }

    public FornecedorModel buscaCnpj(String cnpj) {
//        valida.validaCnpjNaoRegistrado(cnpj);
        return fornecedorRepository.findByCnpj(cnpj);
    }

    public FornecedorModel atualiza(FornecedorModel fornecedor) {
//        valida.validaCnpjNaoRegistrado(fornecedor.getCnpj());
        return fornecedorRepository.save(fornecedor);
    }

    public String alteraStatus(String cnpj, FornecimentoStatusEnum status) {
//        valida.validaCnpjNaoRegistrado(cnpj);
        FornecedorModel fornecedor = buscaCnpj(cnpj);
        fornecedor.setFornecimentoStatusEnum(status);
        atualiza(fornecedor);
        return "O estado de fornecimento foi alterado para: " + fornecedor.getFornecimentoStatusEnum();
    }
}