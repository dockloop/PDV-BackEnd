package backend.pdv.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import backend.pdv.entities.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Long>{

    Page<Operador> findAllByAtivoTrue(Pageable page);
    
}
