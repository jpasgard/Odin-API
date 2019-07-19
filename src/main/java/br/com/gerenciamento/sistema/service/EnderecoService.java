package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.EnderecoModel;
import br.com.gerenciamento.sistema.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements BaseService<EnderecoModel> {

    @Autowired
    private EnderecoRepository eRepo;

    @Override
    public EnderecoModel save(EnderecoModel enderecoModel) {
        return eRepo.save(enderecoModel);
    }

    @Override
    public List<EnderecoModel> findAll() {
        return null;
    }

    @Override
    public EnderecoModel findById(Long id) throws Exception {
        return eRepo.findById(id).orElseThrow(() -> new Exception("Endereço com ID "+ id+ " não encontrado"));
    }

    @Override
    public void delete(Long id) {

    }
}
