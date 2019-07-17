package br.com.gerenciamento.sistema.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<Classe extends Object, Id extends Serializable> extends JpaRepository<Classe, Id> {

    @Modifying
    @Transactional
    @Query("update #{#entityName} set status = 0, data_atualizacao = sysdate where id = ?1")
    public void delete(Long id);
}
