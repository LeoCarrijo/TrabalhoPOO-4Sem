package lvpradoleonardo.com.veiculos.service;

import lvpradoleonardo.com.veiculos.model.dto.MotoDTO;
import lvpradoleonardo.com.veiculos.model.entity.MotoEntity;
import lvpradoleonardo.com.veiculos.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService {
    @Autowired
    MotoRepository injecao;
    public MotoEntity inserirMoto(MotoEntity moto) {
        return injecao.save(moto);
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
