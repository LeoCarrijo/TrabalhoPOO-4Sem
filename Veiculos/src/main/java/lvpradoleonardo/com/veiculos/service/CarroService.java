package lvpradoleonardo.com.veiculos.service;

import lvpradoleonardo.com.veiculos.model.dto.CarroDTO;
import lvpradoleonardo.com.veiculos.model.entity.CarroEntity;
import lvpradoleonardo.com.veiculos.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {
    @Autowired
    CarroRepository injecao;
    public CarroDTO insere(CarroDTO carroDTO) {
        return converteParaDTO(injecao.save(converteParaEntity(carroDTO)));
    }

    public List<CarroDTO> consultarTodos() {
        return converteEntitiesParaDTOs(injecao.findAll());
    }

    public List<CarroDTO> converteEntitiesParaDTOs(List<CarroEntity> carroEntities) {
        List<CarroDTO> carroDTOs = new ArrayList<CarroDTO>();
        for (CarroEntity carroEntity : carroEntities) {
            carroDTOs.add(converteParaDTO(carroEntity));
        }
        return carroDTOs;
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
