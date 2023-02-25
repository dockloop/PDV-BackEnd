package backend.pdv.entities;

import java.text.DecimalFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "idProduto")
    private Categoria categoria;
    private Boolean gelado;
    private DecimalFormat preco;
    private String descricao;


    public Produto(String nome, Categoria categoria, Boolean gelado, String descricao){
        this.nome = nome;
        this.categoria = categoria;
        this.gelado = gelado;
        this.descricao = descricao;
    }
    
}
