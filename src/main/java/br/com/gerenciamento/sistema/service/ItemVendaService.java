package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.ItemVendaModel;
import br.com.gerenciamento.sistema.model.ProdutoModel;
import br.com.gerenciamento.sistema.repository.ItemVendaRepository;
import br.com.gerenciamento.sistema.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService implements BaseService<ItemVendaModel> {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Override
    public ItemVendaModel save(ItemVendaModel itemVendaModel) {
        return null;
    }

    @Override
    public List<ItemVendaModel> findAll() {
        return itemVendaRepository.findAll();
    }

    @Override
    public ItemVendaModel findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
