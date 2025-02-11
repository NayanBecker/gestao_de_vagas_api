package br.com.nayanbecker.gestao_vagas.modules.candidate.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nayanbecker.gestao_vagas.modules.candidate.Entities.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    Optional<CandidateEntity> findByEmailOrUsername(String email, String username);
    Optional<CandidateEntity> findByUsername(String username);
    Optional<CandidateEntity> findByEmail(String email);
    
}
