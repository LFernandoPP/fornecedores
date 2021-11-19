package com.v1.controller;

import com.model.FornecedorModel;
import com.model.FornecimentoStatusEnum;
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
@RequestMapping(path = "/fornecedor/v1")
public class FornecedorController {

    private FornecedorService service;

    @ApiOperation(value = "Cadastra o fornecedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Fornecedor cadastrado com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FornecedorModel cadastra(@RequestBody FornecedorModel fornecedor) {
        return service.cadastra(fornecedor);
    }

    @ApiOperation(value = "Busca por cnpj")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Fornecedor encontrado"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno"),
    })
    @GetMapping(value = "/{cnpj}")
    public FornecedorModel buscaCnpj(@PathVariable String cnpj) {
        return service.buscaCnpj(cnpj);
    }

    @ApiOperation(value = "Altera o status de fornecimento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status alterado com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PutMapping(value = "/{cnpj}/alteraStatus/{novoStatus}")
    public String alteraStatus(@PathVariable String cnpj, @PathVariable FornecimentoStatusEnum novoStatus) {
        return service.alteraStatus(cnpj, novoStatus);
    }
}