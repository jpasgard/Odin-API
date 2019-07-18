package br.com.gerenciamento.sistema.controller;

import br.com.gerenciamento.sistema.model.PessoaModel;
import br.com.gerenciamento.sistema.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<PessoaModel>>findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable("id")Long id){
	service.delete(id);
	return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<PessoaModel> insert(@Valid @RequestBody PessoaModel p){
        PessoaModel pessoa = service.save(p);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaModel> findById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/status/inativos")
    public ResponseEntity<List<PessoaModel>> findInativo(){
        return ResponseEntity.ok().body(service.findInativo());
    }
}
