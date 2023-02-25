package backend.pdv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.pdv.dto.AtualizarOperador;
import backend.pdv.dto.CadastroOperador;
import backend.pdv.dto.DetalhamentoOperador;
import backend.pdv.dto.ListarOperadores;
import backend.pdv.entities.Operador;
import backend.pdv.repositories.OperadorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class OperadorController {
    
    @Autowired
    private OperadorRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoOperador> cadastrar(@RequestBody CadastroOperador cadastroOperador){


        Operador operador = new Operador(cadastroOperador);
        repository.save(operador);

        return ResponseEntity.ok(new DetalhamentoOperador(operador));
    }

    @GetMapping
    public ResponseEntity<Page<ListarOperadores>> listarOperadores(@PageableDefault(size= 10, sort = {"nome"}) Pageable page){
        var paged = repository.findAllByAtivoTrue(page).map(ListarOperadores::new);

        return ResponseEntity.ok(paged);
    }

    @GetMapping
    public ResponseEntity<DetalhamentoOperador> detalharOperador(@PathVariable Long id){
        var operador = repository.getReferenceById(id);
        
        return ResponseEntity.ok(new DetalhamentoOperador(operador));
    }

    @DeleteMapping
    public ResponseEntity<String> excluirOperador(@PathVariable Long id){

        var operador = repository.getReferenceById(id);

        operador.excluir();

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<DetalhamentoOperador> editarOperador(@RequestBody @Valid AtualizarOperador attOperador){

        var operador = repository.getReferenceById(attOperador.id());

        operador.atualizarInfo();

        return ResponseEntity.ok(new DetalhamentoOperador(operador));
    }

}
