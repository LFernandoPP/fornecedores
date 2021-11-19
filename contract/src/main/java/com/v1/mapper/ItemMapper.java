package com.v1.mapper;

import com.model.ItemModel;
import com.v1.dto.request.ItemRequest;
import com.v1.dto.response.ItemResponse;

public class ItemMapper {

    public static ItemResponse mapItemModelParaItemResponse(ItemModel item) {
        return ItemResponse
                .builder()
                .cnpj(item.getCnpj())
                .nomeFantasia(item.getNomeFantasia())
                .item(item.getItem())
                .tempoDeValidade(item.getTempoDeValidade())
                .valor(item.getValor())
                .build();
    }

    public static ItemModel mapItemRequestParaItemModel(ItemRequest item) {
        return ItemModel
                .builder()
                .cnpj(item.getCnpj())
                .nomeFantasia(item.getNomeFantasia())
                .item(item.getItem())
                .tempoDeValidade(item.getTempoDeValidade())
                .valor(item.getValor())
                .build();
    }
}
