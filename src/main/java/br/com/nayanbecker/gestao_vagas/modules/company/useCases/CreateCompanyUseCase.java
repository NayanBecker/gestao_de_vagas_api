package br.com.nayanbecker.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.nayanbecker.gestao_vagas.exceptions.UserFoundException;
import br.com.nayanbecker.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.nayanbecker.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {

    this.companyRepository
        .findByEmailOrUsername(companyEntity.getEmail(), companyEntity.getUsername())
        .ifPresent((user) -> {
            throw new UserFoundException("company already exists");
        });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);

        return this.companyRepository.save(companyEntity);
    }
}
