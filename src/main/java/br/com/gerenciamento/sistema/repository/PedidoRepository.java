package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.EnderecoModel;
import br.com.gerenciamento.sistema.model.PedidoModel;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PedidoRepository extends BaseRepository<PedidoModel, Long> {
}
