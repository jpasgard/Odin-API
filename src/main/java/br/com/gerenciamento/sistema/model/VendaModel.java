package br.com.gerenciamento.sistema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "venda")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "valor_total")
    private Double valorTotal;
    @OneToMany
    @JoinColumn(name = "Fk_venda")
    private List<ItemVendaModel> itens;

}
