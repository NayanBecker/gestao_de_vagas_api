package br.com.nayanbecker.gestao_vagas.modules.candidate.Entities;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    
}
