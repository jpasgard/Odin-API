package br.com.gerenciamento.sistema.controller;

import br.com.gerenciamento.sistema.model.PedidoModel;
import br.com.gerenciamento.sistema.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PedidoModel>> findAll(){
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PedidoModel> insert(@RequestBody PedidoModel p){
        PedidoModel pedido = pedidoService.save(p);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId())
                .toUri();
        return ResponseEntity.created(uri).body(pedido);
    }
}
