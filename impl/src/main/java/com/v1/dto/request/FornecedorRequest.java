package com.v1.dto.request;

import com.model.DepartamentoEnum;
import com.model.FornecimentoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FornecedorRequest {

    @CNPJ
    @Indexed(unique = true)
    private String cnpj;

    @Indexed(unique = true)
    @NotNull(message = "Campo obrigatório")
    @Size(min = 3, max = 100, message = "Min 3, Max 100")
    private String nomeFantasia;

    @Indexed(unique = true)
    @NotNull(message = "Campo obrigatório")
    @Size(min = 3, max = 100, message = "Min 3, Max 100")
    private String razaoSocial;

    private DepartamentoEnum departamentoEnum;

    @Indexed(unique = true)
    @Email
    @Size(min = 5, max = 100, message = "Min 5, Max 100")
    private String email;

    @NotNull(message = "Campo obrigatório")
    @Size(min = 8, max = 20, message = "Min 8, Max 20")
    private String telefone;

    @NotNull(message = "Campo obrigatório")
    @Size(min = 3, max = 100, message = "Min 3, Max 100")
    private String endereco;
    private FornecimentoStatusEnum fornecimentoStatusEnum;
}