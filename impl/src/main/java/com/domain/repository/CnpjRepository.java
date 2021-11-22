package com.repository;

import com.client.CnpjClient;
import com.client.CnpjResponse;
import com.handler.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CnpjRepository {

    private CnpjClient client;

    public Boolean cnpjStatus(String cnpj) {

        CnpjResponse cnpjResponse = client.buscaCnpj(cnpj.replaceAll("[./-]", ""));

        try {
            return cnpjResponse.getStatus().equals("OK");
        } catch (ApiException e) {
            throw new ApiException("Erro na comunicação externa", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}