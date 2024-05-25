package lvpradoleonardo.com.veiculos.service;

import lvpradoleonardo.com.veiculos.model.dto.CarroDTO;
import lvpradoleonardo.com.veiculos.model.entity.CarroEntity;
import lvpradoleonardo.com.veiculos.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    @Autowired
    CarroRepository injecao;
    public CarroDTO insere(CarroDTO carroDTO) {
        return converteParaDTO(injecao.save(converteParaEntity(carroDTO)));
    }

    public CarroDTO converteParaDTO(CarroEntity carroEntity) {
        return new CarroDTO(carroEntity.getId(),
                carroEntity.getMarca(),
                carroEntity.getModelo(),
                carroEntity.getAno(),
                carroEntity.getValor());
    }

    public CarroEntity converteParaEntity(CarroDTO carroDTO) {
        return new CarroEntity(carroDTO.getId(),
                carroDTO.getMarca(),
                carroDTO.getModelo(),
                carroDTO.getAno(),
                carroDTO.getValor());
    }
}
