package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.PedidoModel;
import br.com.gerenciamento.sistema.model.VendaModel;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface VendaRepository extends BaseRepository<VendaModel, Long> {
}
