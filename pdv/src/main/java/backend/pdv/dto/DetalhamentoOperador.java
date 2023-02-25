package backend.pdv.dto;

import java.time.LocalDate;

import backend.pdv.entities.Operador;

public record DetalhamentoOperador(Long id, String nome, String login, String senha, LocalDate dataNascimento, Boolean ativo, String cpf) {

    public DetalhamentoOperador(Operador op){
        this(op.getId(), op.getNome(), op.getLogin(), op.getSenha(), op.getDataNascimento(), op.getAtivo(), op.getCpf());
    }
    
}
