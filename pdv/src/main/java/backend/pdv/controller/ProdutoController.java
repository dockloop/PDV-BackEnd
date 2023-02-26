package backend.pdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.pdv.dto.CadastroProduto;
import backend.pdv.dto.DetalhamentoProduto;
import backend.pdv.entities.Produto;
import backend.pdv.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;

@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<DetalhamentoProduto> registrarProduto(@RequestBody CadastroProduto prod){
        
        Produto produto = new Produto(prod);

        produtoRepository.save(produto);


        return ResponseEntity.ok(new DetalhamentoProduto(produto));

    }
}
