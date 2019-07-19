package br.com.gerenciamento.sistema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orcamento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrcamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private PessoaModel cliente;
    @ManyToMany
    @JoinTable(name="orcamento_produto", joinColumns=
            {@JoinColumn(name="fk_orcamento")}, inverseJoinColumns=
            {@JoinColumn(name="fk_produto")})
    private List<ProdutoModel> produtos;
    private Double desconto; //Guarda o valor em real do desconto, caso o usuário queira usar a flag isPorcentagem como falsa
    private Double valorTotal;// Guarda o valor total de todos os produtos solicitados, com o desconto aplicado
    private Double valorTotalSemDesconto; // Guarda o valor total de todos os produtos solicitados, com o desconto
    private Double porcentagemDesconto; // Guarda a porcentagem de desconto, caso o usuario esteja com a flag isPorcentagem como true
    private Boolean isPorcentagem; // flag para verificar se o desconto será calculado por meio de porcentagem ou com valores fixos
    /**
     * Se o usuário quiser utilizar a opção de desconto por porcentagem
     * é só passar a porcentagem para este atributo e selecionar a flaf isPorcentagem como true
     * caso contrario, será utilizado a porcentagem de desconto com valor fixos
     */
    private Double porcentagemTotalDesconto;
}
