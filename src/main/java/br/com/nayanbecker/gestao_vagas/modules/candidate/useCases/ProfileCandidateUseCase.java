
package br.com.nayanbecker.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.nayanbecker.gestao_vagas.modules.candidate.Entities.CandidateRepository;
import br.com.nayanbecker.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;

@Service
public class ProfileCandidateUseCase {


    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate){
        var candidate = this.candidateRepository.findById(idCandidate)
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Candidate not found");
            });
        var candidateDTO = ProfileCandidateResponseDTO.builder()
            .description(candidate.getDescription())
            .email(candidate.getEmail())
            .name(candidate.getName())
            .phone(candidate.getPhone())
            .username(candidate.getUsername())
            .id(candidate.getId())
            .build();
        return candidateDTO;
    }

}