package com.v1.controller;

import com.model.FornecedorModel;
import com.model.ItemModel;
import com.service.FornecedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Fornecedor controller")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/v1/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;

    @ApiOperation(value = "Registra fornecedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Fornecedor registrado com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FornecedorModel registraFornecedor(@RequestBody FornecedorModel fornecedor) {
        return fornecedorService.registraFornecedor(fornecedor);
    }

    @ApiOperation(value = "Registra itens")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Itens registrados com sucesso"),
            @ApiResponse(code = 404, message = "Não encontado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/itens")
    public void registraItens(@RequestBody List<ItemModel> itens) {
        fornecedorService.registraItens(itens);
    }

    @ApiOperation(value = "Define o estado do fornecedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Fornecedor ativado/desativado com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{cnpj}/defineEstado/{defineEstado}")
    public void defineFornecedorAtivo(@PathVariable String cnpj, @PathVariable char defineEstado) throws Exception {
        fornecedorService.defineFornecedorAtivo(cnpj, defineEstado);
    }
}