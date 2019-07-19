package br.com.gerenciamento.sistema.repository;

import br.com.gerenciamento.sistema.common.BaseRepository;
import br.com.gerenciamento.sistema.model.EnderecoModel;
import br.com.gerenciamento.sistema.model.ItemVendaModel;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ItemVendaRepository extends BaseRepository<ItemVendaModel, Long> {
}
