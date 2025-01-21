package br.com.nayanbecker.gestao_vagas.modules.company.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.nayanbecker.gestao_vagas.modules.company.dto.AuthCompanyRequestDTO;
import br.com.nayanbecker.gestao_vagas.modules.company.dto.AuthCompanyResponseDTO;
import br.com.nayanbecker.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretkey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Object execute(AuthCompanyRequestDTO authCompanyDTO) throws AuthenticationException{
        var company = this.companyRepository.findByEmail(authCompanyDTO.getEmail()).orElseThrow(
            () -> {
                throw new UsernameNotFoundException("Company not found");
            }
        );

        boolean passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMatches){
            throw new AuthenticationException();
        }
        Algorithm algorithm = Algorithm.HMAC256(secretkey);
        var expiresIn = Instant.now().plus(Duration.ofHours(2));
        var token = JWT.create()
            .withIssuer("javagas")
            .withClaim("roles", Arrays.asList("company"))
            .withExpiresAt(expiresIn)
            .withSubject(company.getId().toString())
            .sign(algorithm);

            var authCompanyResponseDTO = AuthCompanyResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.getEpochSecond())
                .build();
            return authCompanyResponseDTO;
    }
    
}
