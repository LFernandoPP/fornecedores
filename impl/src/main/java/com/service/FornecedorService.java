package com.service;

import com.model.FornecedorModel;
import com.model.FornecimentoStatusEnum;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@AllArgsConstructor
@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public FornecedorModel cadastra(FornecedorModel fornecedor) {
        return fornecedorRepository.insert(fornecedor);
    }

    public FornecedorModel buscaCnpj(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj);
    }

    public FornecedorModel atualiza(FornecedorModel fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public FornecedorModel alteraStatus(String cnpj, String novoStatus) {
        FornecedorModel fornecedor = buscaCnpj(cnpj);
        fornecedor.setFornecimentoStatusEnum(FornecimentoStatusEnum.valueOf(novoStatus.toUpperCase(Locale.ROOT)));
        return atualiza(fornecedor);
    }
}