package backend.pdv.entities;

import java.text.DecimalFormat;

import backend.pdv.dto.CadastroProduto;
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
    private int quantidade;


    public Produto(String nome, Categoria categoria, Boolean gelado, String descricao, int quantidade, DecimalFormat preco){
        this.nome = nome;
        this.categoria = categoria;
        this.gelado = gelado;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }


    public Produto(CadastroProduto prod) {
        this.nome = prod.nome();
        this.categoria = prod.categoria();
        this.gelado = prod.gelado();
        this.preco = prod.preco();
        this.descricao = prod.descricao();
        this.quantidade = prod.quantidade();
    }
    
}
