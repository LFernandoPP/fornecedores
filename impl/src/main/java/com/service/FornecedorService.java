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

    public FornecedorModel registraFornecedor(FornecedorModel fornecedor) {
        return fornecedorRepository.insert(fornecedor);
    }

    public void registraItens(ItenFornecidoModel itens) {
        FornecedorModel fm = fornecedorRepository.findByCnpj(itens.getCnpj());
        fm.getListaDeItens().add(itens);
        fornecedorRepository.save(fm);
    }

    public void defineFornecedorAtivo(String cnpj, char defineEstado) throws Exception {
        FornecedorModel fornecedor = fornecedorRepository.findByCnpj(cnpj);

        if (defineEstado == 'S' || defineEstado == 's') {
            fornecedor.setFornecedorAtivo(true);
            fornecedorRepository.save(fornecedor);
        } else if (defineEstado == 'N' || defineEstado == 'n') {
            fornecedor.setFornecedorAtivo(false);
            fornecedorRepository.save(fornecedor);
        } else {
            throw new Exception("Parâmetro inválido");
        }
    }
}