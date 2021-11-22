package com.v1.controller;

import com.facade.ItemFacade;
import com.v1.dto.request.ItemRequest;
import com.v1.dto.response.ItemResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.v1.mapper.ItemMapper.mapItensListRequestToItemListModel;
import static com.v1.mapper.ItemMapper.mapListItemModelToItensListResponse;

@Api(value = "Item controller")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/itens/v1")
public class ItemController {

    private ItemFacade facade;

    @ApiOperation(value = "Cadastra itens")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Itens cadastra com sucesso"),
            @ApiResponse(code = 404, message = "Não encontado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public List<ItemResponse> cadastra(@RequestBody List<ItemRequest> itens) {
        return mapListItemModelToItensListResponse(facade.cadastra(mapItensListRequestToItemListModel(itens)));
    }

    @ApiOperation(value = "Busca lista de itens pelo cnpj")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Itens encontrados"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @GetMapping("/{cnpj}")
    public List<ItemResponse> buscaCnpj(@PathVariable String cnpj) {
        return mapListItemModelToItensListResponse(facade.buscaCnpj(cnpj));
    }

    @ApiOperation(value = "Busca todos os itens")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Itens encontrados"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @GetMapping
    public List<ItemResponse> buscaTodos() {
        return mapListItemModelToItensListResponse(facade.buscaTodos());
    }
}