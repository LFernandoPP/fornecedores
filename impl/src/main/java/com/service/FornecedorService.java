package com.service;

import com.model.FornecedorModel;
import com.model.ItenFornecidoModel;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public FornecedorModel save(FornecedorModel fornecedor) {
        return fornecedorRepository.insert(fornecedor);
    }

    public void registraIten(ItenFornecidoModel iten) {
        FornecedorModel fm = fornecedorRepository.findByCnpj(iten.getCnpj());
        fm.getListaDeItens().add(iten);
        fornecedorRepository.save(fm);
    }

    public void desativaFornecedor(String cnpj) {
        FornecedorModel fornecedor = fornecedorRepository.findByCnpj(cnpj);
        fornecedor.setFornecedorAtivo(false);
        fornecedorRepository.save(fornecedor);
    }

    public void ativaFornecedor(String cnpj) {
        FornecedorModel fornecedor = fornecedorRepository.findByCnpj(cnpj);
        fornecedor.setFornecedorAtivo(true);
        fornecedorRepository.save(fornecedor);
    }
}