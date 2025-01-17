package br.com.nayanbecker.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nayanbecker.gestao_vagas.exceptions.UserFoundException;
import br.com.nayanbecker.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.nayanbecker.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;
    public CompanyEntity execute(CompanyEntity companyEntity) {

    this.companyRepository
        .findByEmailOrUsername(companyEntity.getEmail(), companyEntity.getUsername())
        .ifPresent((user) -> {
            throw new UserFoundException("company already exists");
        });

        return this.companyRepository.save(companyEntity);
    }
}
