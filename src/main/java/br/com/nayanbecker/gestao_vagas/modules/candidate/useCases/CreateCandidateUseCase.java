package br.com.nayanbecker.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.nayanbecker.gestao_vagas.exceptions.UserFoundException;
import br.com.nayanbecker.gestao_vagas.modules.candidate.Entities.CandidateEntity;
import br.com.nayanbecker.gestao_vagas.modules.candidate.repository.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    public CandidateEntity execute(CandidateEntity candidateEntity) {

    this.candidateRepository
        .findByEmailOrUsername(candidateEntity.getEmail(), candidateEntity.getUsername())
        .ifPresent((user) -> {
            throw new UserFoundException("User already exists");
        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return this.candidateRepository.save(candidateEntity);
    }
}
