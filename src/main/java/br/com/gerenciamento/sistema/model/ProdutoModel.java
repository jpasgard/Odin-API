package br.com.gerenciamento.sistema.model;

import br.com.gerenciamento.sistema.model.enuns.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long    id;
    private String nome;
    private Double preco;
    @Column(name = "qnt_produto_estoque")
    private int qntProdutosEstoque;
    @Enumerated(EnumType.ORDINAL)
    private StatusProduto status;
}
