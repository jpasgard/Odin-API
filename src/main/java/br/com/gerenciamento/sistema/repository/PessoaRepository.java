package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.PessoaModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends BaseRepository<PessoaModel, Long> {
    @Query("SELECT p FROM pessoa p where p.status = 0")
    List<PessoaModel> findInativos();
}
