package lvpradoleonardo.com.veiculos.service;

import lvpradoleonardo.com.veiculos.model.dto.MotoDTO;
import lvpradoleonardo.com.veiculos.model.entity.MotoEntity;
import lvpradoleonardo.com.veiculos.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MotoService {
    @Autowired
    MotoRepository injecao;
    public MotoDTO inserirMoto(MotoDTO motoDTO) {
        return converteParaDTO(injecao.save(converteParaEntity(motoDTO)));
    }

    public List<MotoDTO> consultarMotos() {
        return converteEntitiesParaDTO(injecao.findAll());
    }

    public MotoDTO consultarPorId(Long id) {
        Optional<MotoEntity> moto = injecao.findById(id);
        if(moto.isPresent()) {
            return converteParaDTO(moto.get());
        }
        return null;
    }

    public String removerMoto(Long id) {
        if(injecao.existsById(id)) {
            injecao.deleteById(id);
            return "Moto removida com sucesso";
        }
        return "Moto não encontrada para remoção";
    }

    public List<MotoDTO> darDescontoGeral() {
        List<MotoEntity> motos = injecao.findAll();
        for(MotoEntity moto : motos) {
            moto.setValor((float) (moto.getValor() * 0.75));
            injecao.save(moto);
        }
        return converteEntitiesParaDTO(motos);
    }

    public MotoDTO atualizarMoto(Long id, MotoDTO motoDTO) {
        if(injecao.existsById(id)) {
            motoDTO.setId(id);
            return converteParaDTO(injecao.save(converteParaEntity(motoDTO)));
        }
        return null;
    }

    public List<MotoDTO> converteEntitiesParaDTO(List<MotoEntity> motoEntities) {
        List<MotoDTO> motoDTOs = new ArrayList<MotoDTO>();
        for (MotoEntity motoEntity : motoEntities) {
            motoDTOs.add(converteParaDTO(motoEntity));
        }
        return motoDTOs;
    }

    public MotoEntity converteParaEntity(MotoDTO motoDTO) {
        return new MotoEntity(motoDTO.getId(),
                motoDTO.getMarca(),
                motoDTO.getModelo(),
                motoDTO.getAno(),
                motoDTO.getValor(),
                motoDTO.getCc());
    }

    public MotoDTO converteParaDTO(MotoEntity motoEntity) {
        return new MotoDTO(motoEntity.getId(),
                motoEntity.getMarca(),
                motoEntity.getModelo(),
                motoEntity.getAno(),
                motoEntity.getValor(),
                motoEntity.getCc());
    }
}
