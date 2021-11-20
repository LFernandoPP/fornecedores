package com.v1.mapper;

import com.model.ItemModel;
import com.v1.dto.request.ItemRequest;
import com.v1.dto.response.ItemResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static List<ItemResponse> mapListItemModelToItensListResponse(List<ItemModel> item) {
        return item.stream().map(ItemModel -> ItemResponse
                .builder()
                .cnpj(ItemModel.getCnpj())
                .nomeFantasia(ItemModel.getNomeFantasia())
                .item(ItemModel.getItem())
                .tempoDeValidade(ItemModel.getTempoDeValidade())
                .valor(ItemModel.getValor())
                .build()).collect(Collectors.toList());
    }

    public static List<ItemModel> mapItensListRequestToItemListModel(List<ItemRequest> item) {
        return item.stream().map(ItemRequest -> ItemModel
                .builder()
                .cnpj(ItemRequest.getCnpj())
                .nomeFantasia(ItemRequest.getNomeFantasia())
                .item(ItemRequest.getItem())
                .tempoDeValidade(ItemRequest.getTempoDeValidade())
                .valor(ItemRequest.getValor())
                .build()).collect(Collectors.toList());
    }
}