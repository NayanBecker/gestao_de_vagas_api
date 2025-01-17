package br.com.nayanbecker.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nayanbecker.gestao_vagas.exceptions.UserFoundException;
import br.com.nayanbecker.gestao_vagas.modules.candidate.Entities.CandidateEntity;
import br.com.nayanbecker.gestao_vagas.modules.candidate.Entities.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;
    public CandidateEntity execute(CandidateEntity candidateEntity) {

    this.candidateRepository
        .findByEmailOrUsername(candidateEntity.getEmail(), candidateEntity.getUsername())
        .ifPresent((user) -> {
            throw new UserFoundException("User already exists");
        });

        return this.candidateRepository.save(candidateEntity);
    }
}
