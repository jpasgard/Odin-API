package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.ProdutoModel;
import br.com.gerenciamento.sistema.model.enuns.StatusProduto;
import br.com.gerenciamento.sistema.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements BaseService<ProdutoModel> {

    @Autowired
    private ProdutoRepository pRepository;
    @Override
    public ProdutoModel save(ProdutoModel produtoModel) {
        return pRepository.save(produtoModel);
    }

    @Override
    public List<ProdutoModel> findAll() {
        return null;
    }

    @Override
    public ProdutoModel findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public ProdutoModel vender(ProdutoModel p, Integer qntVenda){
        if(p.getStatus() == StatusProduto.ESTOQUE && p.getQntProdutosEstoque() < qntVenda)
            System.out.println("Não existem produtos em estoque");
        else
            p.setQntProdutosEstoque(p.getQntProdutosEstoque() - qntVenda);

        if(p.getQntProdutosEstoque() == 0)
            p.setStatus(StatusProduto.ESTOQUE);

        return pRepository.save(p);
    }
}
