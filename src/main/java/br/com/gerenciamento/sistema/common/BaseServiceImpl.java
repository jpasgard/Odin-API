package br.com.gerenciamento.sistema.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


public class BaseServiceImpl<T extends Object, ID extends Serializable ,R extends BaseRepository<T, ID>> implements BaseService <T>{

    @Autowired
    private R r;

    @Override
    public T save(T t) {
        if(t == null)
            new Exception("Bad request");

        return r.save(t);
    }

    @Override
    public List<T> findAll() {
        return r.findAll();
    }

    @Override
    public T findById(Long id) throws Exception {
        return r.findById((ID) id).orElseThrow(() -> new Exception("Sem registros com o id informado"));
    }

    @Override
    public void delete(Long id) {
        if(id != null)
            r.delete(id);
    }
}
