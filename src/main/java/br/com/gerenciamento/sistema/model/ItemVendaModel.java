package br.com.gerenciamento.sistema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "item_venda")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemVendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double desconto;
    private Integer quantidade;
    private Double preco;
    @Column(name = "momento_pedido")
    private LocalDateTime momentoPedido;
    @ManyToOne
    @JoinColumn(name = "FK_produto_id")
    private ProdutoModel produto;
    @ManyToOne
    @JoinColumn(name = "Fk_endereco_entrega")
    private EnderecoModel enderecoEntrega;
    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private PessoaModel cliente;

}
