package br.com.gerenciamento.sistema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "pessoa")
@Where(clause = "status = 1")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cpfOuCnpj;
    @Enumerated(EnumType.ORDINAL)
    private StatusCliente status;
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
    
	public StatusCliente getStatus() {
		return null;
	}
	public Map<String, ?> getId() {
		return null;
	}

}
