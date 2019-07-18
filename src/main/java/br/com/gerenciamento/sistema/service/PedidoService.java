package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.EnderecoModel;
import br.com.gerenciamento.sistema.model.PedidoModel;
import br.com.gerenciamento.sistema.repository.EnderecoRepository;
import br.com.gerenciamento.sistema.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService implements BaseService<PedidoModel> {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public PedidoModel save(PedidoModel pedidoModel) {
        return pedidoRepository.save(pedidoModel);
    }

    @Override
    public List<PedidoModel> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoModel findById(Long id) throws Exception {
        return pedidoRepository.findById(id).orElseThrow(() -> new Exception("Pedido com o id " + id+ " não existe!"));
    }

    @Override
    public void delete(Long id) {

    }
}
