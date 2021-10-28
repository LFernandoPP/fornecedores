package com.service;

import com.model.FornecedorModel;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void alteraFornecedorAtivo(String cnpj, char alteraEstado) throws Exception {
        FornecedorModel fornecedor = buscaCnpj(cnpj);

        if (alteraEstado == 'S' || alteraEstado == 's') {
            fornecedor.setFornecedorAtivo(true);
            atualiza(fornecedor);
        } else if (alteraEstado == 'N' || alteraEstado == 'n') {
            fornecedor.setFornecedorAtivo(false);
            atualiza(fornecedor);
        } else {
            throw new Exception("Parâmetro inválido");
        }
    }
}