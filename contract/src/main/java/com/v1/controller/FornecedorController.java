package com.v1.controller;

import com.facade.FornecedorFacade;
import com.model.FornecimentoStatusEnum;
import com.v1.dto.request.FornecedorRequest;
import com.v1.dto.response.FornecedorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.v1.mapper.FornecedorMapper.mapFornecedorModelParaFornecedorResponse;
import static com.v1.mapper.FornecedorMapper.mapFornecedorRequestParaFornecedorModel;

@Api(value = "Fornecedor controller")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/fornecedor/v1")
public class FornecedorController {

    private FornecedorFacade facade;

    @ApiOperation(value = "Cadastra o fornecedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Fornecedor cadastrado com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FornecedorResponse cadastra(@RequestBody FornecedorRequest fornecedor) {
        return mapFornecedorModelParaFornecedorResponse(facade.cadastra(mapFornecedorRequestParaFornecedorModel(fornecedor)));
    }

    @ApiOperation(value = "Busca por cnpj")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Fornecedor encontrado"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno"),
    })
    @GetMapping(value = "/{cnpj}")
    public FornecedorResponse buscaCnpj(@PathVariable String cnpj) {
        return mapFornecedorModelParaFornecedorResponse(facade.buscaCnpj(cnpj));
    }

    @ApiOperation(value = "Altera o status de fornecimento")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status alterado com sucesso"),
            @ApiResponse(code = 404, message = "Não encontrado"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PutMapping(value = "/{cnpj}/alteraStatus/{novoStatus}")
    public String alteraStatus(@PathVariable String cnpj, @PathVariable FornecimentoStatusEnum novoStatus) {
        return facade.alteraStatus(cnpj, novoStatus);
    }
}