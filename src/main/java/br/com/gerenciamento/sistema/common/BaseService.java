package br.com.gerenciamento.sistema.common;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends Object> {
    public T save(T t);
    public List<T> findAll();
    public T findById(Long id) throws Exception;
    public void delete(Long id);
}
