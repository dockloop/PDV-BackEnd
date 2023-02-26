package backend.pdv.dto;

import java.text.DecimalFormat;

import backend.pdv.entities.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroProduto(@NotBlank String nome, @NotNull Categoria categoria, @NotNull Boolean gelado, @NotBlank String descricao, @NotNull DecimalFormat preco, @NotNull int quantidade) {

}
