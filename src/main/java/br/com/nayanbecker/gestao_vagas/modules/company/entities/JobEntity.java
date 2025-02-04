package br.com.nayanbecker.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "job")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(description = "Title of the job", example = "Software Engineer")
    @NotBlank(message = "Este campo é obrigatório")
    private String title;

    @Schema(description = "Description of the job", example = "Responsible for developing software solutions")
    @NotBlank(message = "Este campo é obrigatório")
    private String description;

    @Schema(description = "Benefits provided by the job", example = "Health insurance, 401k")
    @NotBlank(message = "Este campo é obrigatório")
    private String benefits;

    @Schema(description = "Level of the job", example = "Senior")
    private String level;

    @ManyToOne()
    @Schema(description = "Company associated with the job")
    @JoinColumn(name = "company_id, insertable = false, updatable = false")
    private CompanyEntity companyEntity;

    @Schema(description = "Unique identifier of the company", example = "123e4567-e89b-12d3-a456-426614174000")
    @Column(name = "company_id")
    private UUID companyId;

    @Schema(description = "Timestamp when the job was created")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
