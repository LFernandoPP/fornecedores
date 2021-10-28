package com.service;

import com.model.FornecedorModel;
import com.model.ItemModel;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemService {

    private FornecedorRepository repository;

    public List<ItemModel> cadastra(List<ItemModel> itens) {
        itens.forEach(item -> {
            FornecedorModel fornecedor = repository.findByCnpj(item.getCnpj());
            fornecedor.getListaItens().add(item);
            repository.save(fornecedor);
        });
        return itens;
    }
}