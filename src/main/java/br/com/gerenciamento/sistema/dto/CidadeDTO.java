package br.com.gerenciamento.sistema.dto;


import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.common.IBaseDTO;

import lombok.Data;

@Data
public class CidadeDTO implements IBaseDTO<CidadeModel, CidadeDTO, Long>{
	private Long id;
	private String nome;

	public CidadeDTO toDto(CidadeModel model){
	    this.id = model.getId();
	    this.nome = model.getNome();
	    return this;
	}
}
