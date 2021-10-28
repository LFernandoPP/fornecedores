package com.controller;

import com.model.FornecedorModel;
import com.model.ItenFornecidoModel;
import com.service.FornecedorService;
import com.service.ItenFornecidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Fornecedor controller")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;
    private ItenFornecidoService itenFornecidoService;

    @ApiOperation(value = "Cadastra Fornecedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Fornecedor registrado"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FornecedorModel save(@RequestBody FornecedorModel fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @GetMapping(value = "/{id}")
    public Optional<FornecedorModel> buscaPorId(@PathVariable String id) {
        return fornecedorService.buscaPorId(id);
    }

    @GetMapping(value = "/cnpj/{id}")
    public FornecedorModel buscaPorCnpj(@PathVariable String cnpj) {
        return itenFornecidoService.findByCnpj(cnpj);
    }

    @ApiOperation(value = "Cadastra item")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Item registrado"),
            @ApiResponse(code = 404, message = "Não encontado"),
            @ApiResponse(code = 500, message = "Erro Interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/itens")
    public void registraIten(@RequestBody ItenFornecidoModel iten) {
        itenFornecidoService.registraIten(iten);
    }

    @GetMapping(value = "/itens/{cnpj}")
    public List<ItenFornecidoModel> buscaTodosItens(@PathVariable String cnpj) {
        return itenFornecidoService.buscaTodos(cnpj);
    }

    @ApiOperation(value = "Ativa o fornecedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação ocorrida com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PutMapping(value = "/ativa/{cnpj}")
    public void ativaFornecedor(@PathVariable String cnpj) {
        fornecedorService.ativaFornecedor(cnpj);
    }

    @ApiOperation(value = "Desativa o fornecedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação ocorrida com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PutMapping(value = "/desativa/{cnpj}")
    public void desativaFornecedor(@PathVariable String cnpj) {
        fornecedorService.desativaFornecedor(cnpj);
    }

    @PutMapping(value = "/trocaDepartamento/{cnpj}-{departamento}")
    public void trocaDepartamento(@PathVariable String cnpj, @PathVariable String departamento) {
        fornecedorService.trocaDepartamento(cnpj, departamento);
    }

    @ApiOperation(value = "Verifica o estado do fornecedor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação ocorrida com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @GetMapping(value = "/verificaEstado/{cnpj}")
    public ResponseEntity<Boolean> verificaEstado(@PathVariable String cnpj) {
        return ResponseEntity.ok(fornecedorService.fornecedorAtivo(cnpj));
    }
}