package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.model.EstadoModel;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends BaseRepository<EstadoModel, Long> {

}
