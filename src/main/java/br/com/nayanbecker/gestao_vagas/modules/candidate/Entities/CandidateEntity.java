package br.com.nayanbecker.gestao_vagas.modules.candidate.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
@Schema(description = "Entity representing a candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "Unique identifier of the candidate", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Length(max = 200)
    @Schema(description = "Name of the candidate", example = "John Doe")
    private String name;

    @Pattern(regexp = "^[A-z]\\S+{3,30}$", message = "Username should have between 3 and 30 characters and can't contain spaces")
    @Schema(description = "Username of the candidate", example = "johndoe")
    private String username;

    @Email(message = "Email should be valid")
    @Schema(description = "Email address of the candidate", example = "johndoe@example.com")
    private String email;

    @Length(min=6, message = "Password should have at least 6 characters")
    @Schema(description = "Password of the candidate", example = "password123")
    private String password;

    @Schema(description = "Phone number of the candidate", example = "+1234567890")
    private String phone;

    @Length(max = 500)
    @Schema(description = "Description of the candidate", example = "Experienced software developer")
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
