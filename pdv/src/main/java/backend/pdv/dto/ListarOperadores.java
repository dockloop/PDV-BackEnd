package backend.pdv.dto;

import java.time.LocalDate;

import backend.pdv.entities.Operador;

public record ListarOperadores(Long id, String nome, String cpf, LocalDate dataNascimento) {
    
    public ListarOperadores(Operador operadores){
        this(operadores.getId(), operadores.getNome(), operadores.getCpf(), operadores.getDataNascimento());
    }
}
