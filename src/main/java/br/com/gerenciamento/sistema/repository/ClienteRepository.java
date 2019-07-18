package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.PessoaModel;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ClienteRepository extends BaseRepository<PessoaModel, Long> {
//    @Query("SELECT p FROM pessoa p where p.status = 0 group by p.id")
//    List<PessoaModel> findInativos();
}
