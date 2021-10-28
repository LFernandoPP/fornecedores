package com.v1.controller;

import com.model.FornecedorModel;
import com.model.ItenFornecidoModel;
import com.service.FornecedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(value = "Fornecedor controller")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;

    @ApiOperation(value = "Registra fornecedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Fornecedor registrado"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FornecedorModel cadastraFornecedor(@RequestBody FornecedorModel fornecedor) {
        return fornecedorService.registraFornecedor(fornecedor);
    }

    @ApiOperation(value = "Registra itens")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Itens registrados"),
            @ApiResponse(code = 404, message = "Não encontado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/itens")
    public void cadastraItens(@RequestBody ItenFornecidoModel itens) {
        fornecedorService.registraItens(itens);
    }

    @ApiOperation(value = "Ativa o fornecedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Fornecedor ativado"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PutMapping(value = "/ativa/{cnpj}")
    public void ativaFornecedor(@PathVariable String cnpj) {
        fornecedorService.ativaFornecedor(cnpj);
    }

    @ApiOperation(value = "Desativa o fornecedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Fornecedor desativado"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PutMapping(value = "/desativa/{cnpj}")
    public void desativaFornecedor(@PathVariable String cnpj) {
        fornecedorService.desativaFornecedor(cnpj);
    }
}