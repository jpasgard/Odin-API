package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.EnderecoModel;
import br.com.gerenciamento.sistema.model.ItemVendaModel;
import br.com.gerenciamento.sistema.model.PedidoModel;
import br.com.gerenciamento.sistema.model.VendaModel;
import br.com.gerenciamento.sistema.repository.EnderecoRepository;
import br.com.gerenciamento.sistema.repository.ItemVendaRepository;
import br.com.gerenciamento.sistema.repository.VendaRepository;
import br.com.gerenciamento.sistema.service.utils.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService implements BaseService<VendaModel> {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemVendaService itemVendaService;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Override
    public VendaModel save(VendaModel vendaModel) {
        return null;
    }

    @Override
    public List<VendaModel> findAll() {
        return vendaRepository.findAll();
    }

    @Override
    public VendaModel findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    /**
     * @Author Rafael Castro
     *
     * Refatorar esse método de realizar a venda, discutir se é necessário o item da venda
     * Refatorar quando não encontrar o tem da venda lançar uma exceção personalizada a criar (NotFoundException)
     * Refatorar para quando for realizado uma venda enviar um e-mail para o cliente que realizou a compra
     *
     * @param listItemVendaId recebe uma String com o número itens da venda a ser realizada. Exemplo: 6,4,1
     * @return Retorna a venda realizada
     * @throws Exception
     */
    public VendaModel realizarVenda(String listItemVendaId) throws Exception {
        List<ItemVendaModel> itens = new ArrayList<>();
        List<Long> idItens = Uri.decodeIntList(listItemVendaId);
        Double valorTotalPedido = 0.0;
        Double valortotalDesconto = 0.0;

        idItens.forEach(id -> {
            itens.add(itemVendaRepository.findById(id).get());
        });

        valortotalDesconto = itens.stream().mapToDouble(ItemVendaModel::getDesconto).sum();
        valorTotalPedido = itens.stream().mapToDouble(ItemVendaModel::getPreco).sum();

        valorTotalPedido -= valortotalDesconto;

        VendaModel venda = new VendaModel(null, valorTotalPedido, itens);

        return vendaRepository.save(venda);

    }
}
