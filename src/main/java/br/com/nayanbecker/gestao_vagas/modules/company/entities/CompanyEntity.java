package br.com.nayanbecker.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "company")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(max = 200)
    private String name;

    @Pattern(regexp = "^[A-z]\\S+{3,30}$", message = "Username should have between 3 and 30 characters")
    private String username;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;
    
    @NotBlank
    @Length(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @Length(max = 500)
    private String description;
    private String website;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
