package com.service;

import com.model.FornecedorModel;
import com.model.ItenFornecidoModel;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    public FornecedorModel registraFornecedor(FornecedorModel fornecedor) {
        return fornecedorRepository.insert(fornecedor);
    }

    public void registraItens(List<ItenFornecidoModel> itens) {
        itens.forEach(i -> {
            FornecedorModel fornecedor = buscaFornecedorCnpj(i.getCnpj());
            fornecedor.getListaDeItens().add(i);
            atualizaFornecedor(fornecedor);
        });
    }

    public FornecedorModel buscaFornecedorCnpj(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj);
    }

    public FornecedorModel atualizaFornecedor(FornecedorModel fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void defineFornecedorAtivo(String cnpj, char defineEstado) throws Exception {
        FornecedorModel fornecedor = buscaFornecedorCnpj(cnpj);

        if (defineEstado == 'S' || defineEstado == 's') {
            fornecedor.setFornecedorAtivo(true);
            atualizaFornecedor(fornecedor);
        } else if (defineEstado == 'N' || defineEstado == 'n') {
            fornecedor.setFornecedorAtivo(false);
            atualizaFornecedor(fornecedor);
        } else {
            throw new Exception("Parâmetro inválido");
        }
    }
}