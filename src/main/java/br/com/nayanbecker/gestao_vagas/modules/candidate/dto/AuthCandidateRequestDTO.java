package br.com.nayanbecker.gestao_vagas.modules.candidate.dto;

public record AuthCandidateRequestDTO(
    String email,
    String password
) {}
