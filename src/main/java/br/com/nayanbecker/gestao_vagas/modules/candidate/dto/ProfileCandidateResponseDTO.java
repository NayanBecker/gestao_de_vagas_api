package br.com.nayanbecker.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {
        @Schema(description = "Description of the candidate", example = "Experienced Java Developer")
        private String description;

        @Schema(description = "Username of the candidate", example = "john_doe")
        private String username;

        @Schema(description = "Email of the candidate", example = "john.doe@example.com")
        private String email;

        @Schema(description = "Phone number of the candidate", example = "+1234567890")
        private String phone;

        @Schema(description = "Name of the candidate", example = "John Doe")
        private String name;

        private UUID id;
}
