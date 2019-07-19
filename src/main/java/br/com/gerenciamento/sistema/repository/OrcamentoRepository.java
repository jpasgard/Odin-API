package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.model.OrcamentoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrcamentoRepository extends BaseRepository<OrcamentoModel, Long> {

}
