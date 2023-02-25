package backend.pdv.entities;

import java.time.LocalDate;

import backend.pdv.dto.CadastroOperador;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operadores")
public class Operador extends User{
    

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Boolean ativo;



    public Operador(CadastroOperador cadastroOperador){
        super(cadastroOperador.login(), cadastroOperador.senha());
        this.nome = cadastroOperador.nome();
        this.dataNascimento = cadastroOperador.dataNascimento();
        this.cpf = cadastroOperador.cpf();
        this.ativo = true;
    }



    public void excluir() {
        this.ativo = false;
    }

    public void atualizarInfo(){
        
    }

}
