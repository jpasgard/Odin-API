package br.com.gerenciamento.sistema.common;

import java.io.Serializable;

public interface IBaseDTO<Model extends Object,Dto extends IBaseDTO, Id extends Serializable> {
	public Dto toDto(Model dto);
}
