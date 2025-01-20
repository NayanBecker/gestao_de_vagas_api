package br.com.nayanbecker.gestao_vagas.modules.candidate.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(max = 200)
    private String name;

    @Pattern(regexp = "^[A-z]\\S+{3,30}$", message = "Username should have between 3 and 30 characters and can't contain spaces")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @Length(min=6, message = "Password should have at least 6 characters")
    private String password;

    private String phone;

    @Length(max = 500)
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
