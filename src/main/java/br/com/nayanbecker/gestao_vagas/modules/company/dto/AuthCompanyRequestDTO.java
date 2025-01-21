package br.com.nayanbecker.gestao_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthCompanyRequestDTO {
    private String email;
    private String password;
}
