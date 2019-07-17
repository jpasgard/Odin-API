package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.PessoaModel;
import br.com.gerenciamento.sistema.model.StatusCliente;
import br.com.gerenciamento.sistema.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService implements BaseService<PessoaModel>{
    @Autowired
    private PessoaRepository rRepo;

    @Override
    public PessoaModel save(PessoaModel pessoaModel) {
        return rRepo.save(pessoaModel);
    }

    @Override
    public List<PessoaModel> findAll() {
        return rRepo.findAll();
    }

    @Override
    public PessoaModel findById(Long id) throws Exception {
        return rRepo.findById(id).orElseThrow(()-> new Exception("Problema ao encontrar o id" + id));
    }

    @Override
    public void delete(Long id) {
        rRepo.delete(id);
    }

    public List<PessoaModel> findInativo(){
        return rRepo.findAll().stream().filter(x -> {
          return x.getStatus() == StatusCliente.INATIVO;
        }).collect(Collectors.toList());
    }
}
