package com.service;

import com.model.FornecedorModel;
import com.model.ItenFornecidoModel;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItenFornecidoService {

    private FornecedorRepository fornecedorRepository;

    public void registraIten(ItenFornecidoModel iten) {
        FornecedorModel fm = findByCnpj(iten.getCnpj());
        fm.getListaDeItens().add(iten);
        fornecedorRepository.save(fm);
    }

    public List<ItenFornecidoModel> buscaTodos(String cnpj) {
        FornecedorModel lista = findByCnpj(cnpj);
//        if (!validaFornecedor(fornecedor))
        if (!lista.getCnpj().equals(cnpj))
            throw new RuntimeException("Fornecedor Invalido");
        return lista.getListaDeItens();
    }

    public FornecedorModel findByCnpj(String cnpj) {
        return fornecedorRepository.findByCnpj(cnpj);
    }

//    public boolean validaFornecedor(FornecedorModel fornecedor){
//        return findByCnpj(fornecedor.getCnpj()).equals(fornecedor);
//    }
}