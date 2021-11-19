package com.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CnpjResponse {


    private String cnpj;
    private String status;
    private String message;
}