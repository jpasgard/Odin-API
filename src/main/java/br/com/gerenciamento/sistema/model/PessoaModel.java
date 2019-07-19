package br.com.gerenciamento.sistema.model;

import br.com.gerenciamento.sistema.model.enuns.StatusPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "pessoa")
@Where(clause = "status = 1")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cpfOuCnpj;
    @Enumerated(EnumType.ORDINAL)
    private StatusPessoa status;
    @Column(name = "data_atualizacao")
    @JsonIgnore
    private LocalDateTime dataAtualizacao;
    @OneToMany
    @JoinColumn(name = "FK_endereco")
    private List<EnderecoModel> endereco;
    @ElementCollection
    @CollectionTable(name = "telefone")
    private Set<String> telefones = new HashSet<>();
}
