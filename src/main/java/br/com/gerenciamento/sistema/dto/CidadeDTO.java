package br.com.gerenciamento.sistema.dto;

import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.common.IBaseDTO;

import lombok.Data;
import javax.validation.constraints.Max;

@Data
public class CidadeDTO implements IBaseDTO<CidadeModel, CidadeDTO, Long>{
	private Long id;

    @Max(value = 200, message = "Age should not be less than 200")
	private String nome;

	public CidadeDTO toDto(CidadeModel model){
	    this.id = model.getId();
	    this.nome = model.getNome();
	    return this;
	}
}
