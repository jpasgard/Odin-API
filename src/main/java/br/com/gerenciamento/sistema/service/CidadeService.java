package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.repository.CidadeRepository;
import br.com.gerenciamento.sistema.dto.CidadeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class CidadeService implements BaseService<CidadeModel> {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public CidadeModel save(CidadeModel cidadeModel) {
        return cidadeRepository.save(cidadeModel);
    }

    @Override
    public List<CidadeModel> findAll() {
        return cidadeRepository.findAll();
    }

    @Override
    public CidadeModel findById(Long id) throws Exception {
        return cidadeRepository.findById(id).orElseThrow(()->new Exception("Cidade de id "+ id+ " não encontrada"));
    }

    @Override
    public void delete(Long id) {

    }

    public List<CidadeModel> findByEstado(Long id){
        return cidadeRepository.findByEstado(id);
    }

    public List<CidadeDTO> toDto(List<CidadeModel> models){
        CidadeDTO dto = new CidadeDTO();
        List<CidadeDTO> dtos = new ArrayList<>();

        models.forEach(model->{
            dtos.add(dto.toDto(model));
        });
        return dtos;
    }
}
