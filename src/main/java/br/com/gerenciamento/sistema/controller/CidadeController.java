package br.com.gerenciamento.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<CidadeModel>>findAll(){
        return ResponseEntity.ok().body(cidadeService.findAll());
    }

    @GetMapping(value = "/estado/{id}")
    public ResponseEntity<List<CidadeModel>>findByEstado(@PathVariable("id")Long idEstado){
        return ResponseEntity.ok().body(cidadeService.findByEstado(idEstado));
    }


}
