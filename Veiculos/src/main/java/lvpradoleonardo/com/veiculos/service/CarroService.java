package lvpradoleonardo.com.veiculos.service;

import lvpradoleonardo.com.veiculos.model.dto.CarroDTO;
import lvpradoleonardo.com.veiculos.model.entity.CarroEntity;
import lvpradoleonardo.com.veiculos.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    CarroRepository injecao;
    public CarroDTO insere(CarroDTO carroDTO) {
        return converteParaDTO(injecao.save(converteParaEntity(carroDTO)));
    }

    public List<CarroDTO> consultarCarros() {
        return converteEntitiesParaDTOs(injecao.findAll());
    }

    public List<CarroDTO> converteEntitiesParaDTOs(List<CarroEntity> carroEntities) {
        List<CarroDTO> carroDTOs = new ArrayList<CarroDTO>();
        for (CarroEntity carroEntity : carroEntities) {
            carroDTOs.add(converteParaDTO(carroEntity));
        }
        return carroDTOs;
    }

    public CarroDTO consultarPorId(Long id) {
        Optional<CarroEntity> carroEntity = injecao.findById(id);
        if (carroEntity.isPresent()) {
            return converteParaDTO(carroEntity.get());
        }
        return null;
    }

    public String removerCarro(Long id) {
        if (injecao.existsById(id)) {
            injecao.deleteById(id);
            return "Carro removido com sucesso!";
        }
        return "Carro não encontrado para remoção";
    }

    public List<CarroDTO> darDescontoGeral() {
        List<CarroEntity> carroEntities = injecao.findAll();
        for (CarroEntity carroEntity : carroEntities) {
            carroEntity.setValor((float) (carroEntity.getValor() * 0.80));
            injecao.save(carroEntity);
        }
        return converteEntitiesParaDTOs(carroEntities);
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
