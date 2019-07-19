package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.CidadeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CidadeRepository extends BaseRepository<CidadeModel, Long> {
    @Transactional(readOnly = true)
    @Query("SELECT c FROM cidade c where c.estado.id = :estadoId order by c.nome")
    List<CidadeModel> findByEstado(@Param("estadoId") Long id);
}
