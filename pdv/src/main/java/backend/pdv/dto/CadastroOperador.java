package backend.pdv.dto;

import java.time.LocalDate;

public record CadastroOperador(String nome, String cpf, String login, String senha, LocalDate dataNascimento) {

}
