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
import br.com.gerenciamento.sistema.dto.CidadeDTO;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    public ResponseEntity<List<CidadeDTO>>findAll(){
        return ResponseEntity.ok().body(toDto(service.findAll()));
    }

    @GetMapping(value = "/estado/{id}")
    public ResponseEntity<List<CidadeDTO>>findByEstado(@PathVariable("id")Long idEstado){
        return ResponseEntity.ok().body(toDto(service.findByEstado(idEstado)));
    }

    private List<CidadeDTO> toDto(List<CidadeModel> models){
        return service.toDto(models);
    }
}
