package backend.pdv.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record AtualizarOperador(@NotNull Long id, String nome, String login, String senha, LocalDate dataNascimento, Boolean ativo, String cpf) {
    
}
