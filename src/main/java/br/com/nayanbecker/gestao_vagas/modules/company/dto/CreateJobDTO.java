package br.com.nayanbecker.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Desenvolvedor Java", requiredMode = RequiredMode.REQUIRED)
    private String title;
    @Schema(example = "Desenvolvedor Java com experiencia de no minino 2 anos na area", requiredMode = RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "VR, Gympass, Salario", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "Pleno", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
