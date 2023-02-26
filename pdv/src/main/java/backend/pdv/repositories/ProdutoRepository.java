package backend.pdv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.pdv.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
