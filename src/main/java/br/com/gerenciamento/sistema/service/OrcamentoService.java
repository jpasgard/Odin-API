package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.model.OrcamentoModel;
import br.com.gerenciamento.sistema.model.ProdutoModel;
import br.com.gerenciamento.sistema.repository.CidadeRepository;
import br.com.gerenciamento.sistema.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoService implements BaseService<OrcamentoModel> {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    /**
     *
     * @param orcamentoModel Solicitação do orcamento
     * @see
     * @return
     */
    @Override
    public OrcamentoModel save(OrcamentoModel orcamentoModel) {
        OrcamentoModel orcamentoCalculado = orcamentoModel.getIsPorcentagem()?
                this.calcularValorOrcamentoPorPortentagem(orcamentoModel):this.calcularValorOrcamentoComDescontoEmDinheiro(orcamentoModel);

        return orcamentoRepository.save(orcamentoCalculado);
    }

    @Override
    public List<OrcamentoModel> findAll() {
        return null;
    }

    @Override
    public OrcamentoModel findById(Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    /**
     * @Author Rafael Castro
     *
     * @param orcamentoModel A solicitação de orçamento
     * @return Orcamento com o desconto calculado com valores fixos
     */
    private OrcamentoModel calcularValorOrcamentoComDescontoEmDinheiro(OrcamentoModel orcamentoModel){
        List<ProdutoModel> produtos = orcamentoModel.getProdutos();
        Double total = 0.0;

        total = produtos.stream().mapToDouble(ProdutoModel::getPreco).sum();
        orcamentoModel.setValorTotalSemDesconto(total);
        total -= orcamentoModel.getDesconto();
        orcamentoModel.setPorcentagemDesconto((orcamentoModel.getDesconto()/orcamentoModel.getValorTotalSemDesconto())*100);

        orcamentoModel.setValorTotal(total);
        return orcamentoModel;
    }

    /**
     * @Author Rafael Castro
     *
     * @param orcamentoModel Solicitação para realizar um orçamento
     * @return Orcamento com o desconto calculado por porcentagem
     */
    private OrcamentoModel calcularValorOrcamentoPorPortentagem(OrcamentoModel orcamentoModel){
        List<ProdutoModel> produtos = orcamentoModel.getProdutos();
        Double totalPrecoTodosProdutos = 0.0;
        Double porcentagemDesconto = 0.0;
        Double totalDesconto = 0.0;

        totalPrecoTodosProdutos = produtos.stream().mapToDouble(ProdutoModel::getPreco).sum();
        porcentagemDesconto = orcamentoModel.getPorcentagemTotalDesconto();

        totalDesconto = (totalDesconto / 100) * totalPrecoTodosProdutos ;

        orcamentoModel.setValorTotalSemDesconto(totalPrecoTodosProdutos);
        orcamentoModel.setDesconto(totalDesconto);
        orcamentoModel.setValorTotal(totalPrecoTodosProdutos - totalDesconto);

        return orcamentoModel;
    }
}
