package com.service;

import com.model.FornecedorModel;
import com.model.ItemModel;
import com.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ItemModel> buscaCnpj(String cnpj) {
        return repository.findByCnpj(cnpj).getListaItens();
    }

    public List<ItemModel> buscaTodos() {

        List<FornecedorModel> fornecedores = repository.findAll();
        List<ItemModel> novaLista = new ArrayList<>();

        fornecedores.forEach(lista ->
                novaLista.addAll(lista.getListaItens()));
        return novaLista;
    }
}