package com.facade;

import com.model.ItemModel;
import com.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ItemFacade {

    private ItemService service;

    public List<ItemModel> cadastra(List<ItemModel> itens) {
        return service.cadastra(itens);
    }

    public List<ItemModel> buscaCnpj(String cnpj) {
        return service.buscaCnpj(cnpj);
    }

    public List<ItemModel> buscaTodos() {
        return service.buscaTodos();
    }

}