package com.service;

import com.model.Departamento;
import com.model.FornecedorModel;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public FornecedorModel save(FornecedorModel fornecedor) {
        return fornecedorRepository.insert(fornecedor);
    }

    public Optional<FornecedorModel> buscaPorId(String id) {
        return fornecedorRepository.findById(id);
    }

    public void trocaDepartamento(String cnpj, String departamento) {
        FornecedorModel fornecedor = fornecedorRepository.findByCnpj(cnpj);
        fornecedor.setDepartamento(Departamento.valueOf(departamento.toUpperCase(Locale.ROOT)));
        fornecedorRepository.save(fornecedor);
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

    public boolean fornecedorAtivo(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj).isFornecedorAtivo();
    }
}