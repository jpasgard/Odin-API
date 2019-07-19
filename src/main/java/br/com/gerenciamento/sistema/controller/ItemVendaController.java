package br.com.gerenciamento.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamento.sistema.model.ItemVendaModel;
import br.com.gerenciamento.sistema.service.ItemVendaService;

@RestController
@RequestMapping("/itens")
public class ItemVendaController {
    @Autowired
    private ItemVendaService itemVendaService;

    @GetMapping
    public ResponseEntity<List<ItemVendaModel>> findAll(){
        return ResponseEntity.ok().body(itemVendaService.findAll());
    }
}
