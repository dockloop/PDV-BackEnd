package backend.pdv.dto;

import java.text.DecimalFormat;

import backend.pdv.entities.Categoria;
import backend.pdv.entities.Produto;

public record DetalhamentoProduto(Long id, String nome, Categoria categoria, Boolean gelado, DecimalFormat preco, String descricao, int quantidade) {


    public DetalhamentoProduto(Produto prod){
        this(prod.getId(), prod.getNome(), prod.getCategoria(), prod.getGelado(), prod.getPreco(), prod.getDescricao(), prod.getQuantidade());
    }
}
