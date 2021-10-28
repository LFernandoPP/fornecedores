package com.v1.controller;

import com.model.ItemModel;
import com.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Item controller")
@RestController
@AllArgsConstructor
@RequestMapping("/v1/itens")
public class ItemController {

    private ItemService service;

    @ApiOperation(value = "Cadastra itens")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Itens cadastra com sucesso"),
            @ApiResponse(code = 404, message = "Não encontado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public List<ItemModel> cadastra(@RequestBody List<ItemModel> itens) {
        return service.cadastra(itens);
    }

    @ApiOperation(value = "Busca lista de itens pelo cnpj")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Itens encontrados"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{cnpj}")
    public List<ItemModel> buscaCnpj(@PathVariable String cnpj) {
        return service.buscaCnpj(cnpj);
    }

    @ApiOperation(value = "Busca todos os itens")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Itens encontrados"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ItemModel> buscaTodos() {
        return service.buscaTodos();
    }
}