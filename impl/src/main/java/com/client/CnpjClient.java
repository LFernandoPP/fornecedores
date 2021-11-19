package com.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cnpj-service", url = "https://www.receitaws.com.br/v1/cnpj")
public interface CnpjClient {

    @GetMapping("/{cnpj}")
    public CnpjResponse buscaCnpj(@PathVariable("cnpj")  String cnpj);
}