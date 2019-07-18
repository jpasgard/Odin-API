package br.com.gerenciamento.sistema.controller;

import br.com.gerenciamento.sistema.model.ItemVendaModel;
import br.com.gerenciamento.sistema.model.PedidoModel;
import br.com.gerenciamento.sistema.service.ItemVendaService;
import br.com.gerenciamento.sistema.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemVendaController {
    @Autowired
    private ItemVendaService itemVendaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ItemVendaModel>> findAll(){
        return ResponseEntity.ok().body(itemVendaService.findAll());
    }
}
