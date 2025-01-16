package br.com.nayanbecker.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    
    private UUID id;
    @Length(max = 200)
    private String name;
    @Pattern(regexp = "^[A-z]{3,15}$", message = "Username should have between 3 and 15 characters")
    private String username;
    @Email(message = "Email should be valid")
    private String email;
    @Length(min=6, message = "Password should have at least 6 characters")
    private String password;
    private String phone;
    @Length(max = 500)
    private String description;

    
}
