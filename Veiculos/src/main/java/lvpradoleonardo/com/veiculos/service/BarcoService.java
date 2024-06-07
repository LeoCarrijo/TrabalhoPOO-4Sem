package lvpradoleonardo.com.veiculos.service;

import lvpradoleonardo.com.veiculos.model.dto.BarcoDTO;
import lvpradoleonardo.com.veiculos.model.dto.CarroDTO;
import lvpradoleonardo.com.veiculos.model.entity.BarcoEntity;
import lvpradoleonardo.com.veiculos.model.entity.CarroEntity;
import lvpradoleonardo.com.veiculos.model.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BarcoService {
    @Autowired
    BarcoRepository injecao;

    public BarcoDTO insere(BarcoDTO barcoDTO) {
        return converteParaDTO(injecao.save(converteParaEntity(barcoDTO)));
    }

    public BarcoDTO consultarPorId(Long id) {
        Optional<BarcoEntity> barcoEntity = injecao.findById(id);
        if(barcoEntity.isPresent()) {
            return converteParaDTO(barcoEntity.get());
        }
        return null;
    }

    public String removerbarco(Long id) {
        if(injecao.existsById(id)) {
            injecao.deleteById(id);
            return "Barco removido com sucesso";
        }
        return "Barco não encontrado para remoção";
    }

    public List<BarcoDTO> transformarAltoMar() {
        List<BarcoEntity> barcoEntities = injecao.findAll();
        for(BarcoEntity barcoEntity : barcoEntities){
            barcoEntity.setAlto_mar(true);
            injecao.save(barcoEntity);
        }
        return converterEntitiesParaDTOs(barcoEntities);
    }

    public BarcoDTO atualizarPorId(BarcoDTO barcoDTO, Long id) {
        if(injecao.existsById(id)) {
            barcoDTO.setId(id);
            return converteParaDTO(injecao.save(converteParaEntity(barcoDTO)));
        }
        return null;
    }

    public List<BarcoDTO> consultarBarcos() {
        return converterEntitiesParaDTOs(injecao.findAll());
    }

    public List<BarcoDTO> converterEntitiesParaDTOs(List<BarcoEntity> barcoEntities) {
        List<BarcoDTO> barcoDTOs = new ArrayList<BarcoDTO>();
        for (BarcoEntity barcoEntity : barcoEntities) {
            barcoDTOs.add(converteParaDTO(barcoEntity));
        }
        return barcoDTOs;
    }

    public BarcoDTO converteParaDTO(BarcoEntity barcoEntity) {
        return new BarcoDTO(barcoEntity.getId(),
                barcoEntity.getMarca(),
                barcoEntity.getModelo(),
                barcoEntity.isAlto_mar(),
                barcoEntity.getValor());
    }

    public BarcoEntity converteParaEntity(BarcoDTO barcoDTO) {
        return new BarcoEntity(barcoDTO.getId(),
                barcoDTO.getMarca(),
                barcoDTO.getModelo(),
                barcoDTO.isAlto_mar(),
                barcoDTO.getValor());
    }
}
