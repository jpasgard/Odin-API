package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.EnderecoModel;
import br.com.gerenciamento.sistema.model.PessoaModel;
import br.com.gerenciamento.sistema.model.enuns.StatusPessoa;
import br.com.gerenciamento.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService implements BaseService<PessoaModel>{
    @Autowired
    private ClienteRepository rRepo;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public PessoaModel save(PessoaModel pessoaModel) {
        pessoaModel.setStatus(StatusPessoa.ATIVO);
        List<EnderecoModel> enderecos = new ArrayList<>();

        if(pessoaModel.getEndereco() != null){
            pessoaModel.getEndereco().forEach(e ->{
                enderecos.add(enderecoService.save(e));
            });
            pessoaModel.setEndereco(enderecos);
        }
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

}
