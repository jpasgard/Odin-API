package br.com.gerenciamento.sistema.service;

import br.com.gerenciamento.sistema.common.BaseService;
import br.com.gerenciamento.sistema.model.CidadeModel;
import br.com.gerenciamento.sistema.repository.CidadeRepository;
import br.com.gerenciamento.sistema.dto.CidadeDTO;
import br.com.gerenciamento.sistema.service.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class CidadeService implements BaseService<CidadeModel> {

    @Autowired
    private CidadeRepository repository;

    @Override
    public CidadeModel save(CidadeModel cidadeModel) {
        return repository.save(cidadeModel);
    }

    @Override
    public List<CidadeModel> findAll() {
        return repository.findAll();
    }

    @Override
    public CidadeModel findById(Long id) throws ObjectNotFoundException {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + CidadeModel.class.getName()));
    }

    @Override
    public void delete(Long id) {

    }

    public List<CidadeModel> findByEstado(Long id){
        return repository.findByEstado(id);
    }

    public CidadeDTO toDto(CidadeModel model){
        return new CidadeDTO().toDto(model);
    }

    public List<CidadeDTO> toDtos(List<CidadeModel> models){
        CidadeDTO dto = new CidadeDTO();
        List<CidadeDTO> dtos = new ArrayList<>();

        models.forEach(model->{
            dtos.add(dto.toDto(model));
        });
        return dtos;
    }
}
