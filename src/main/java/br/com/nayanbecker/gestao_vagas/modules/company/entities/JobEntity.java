package br.com.nayanbecker.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "job")
public class JobEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Este campo é obrigatório")
    private String title;

    @NotBlank(message = "Este campo é obrigatório")
    private String description;

    @NotBlank(message = "Este campo é obrigatório")
    private String benefits;
    private String level;

    @ManyToOne()
    @JoinColumn(name = "company_id, insertable = false, updatable = false")
    private CompanyEntity companyEntity;

    @Column(name = "company_id")
    @NotNull(message = "Este campo é obrigatório")
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
