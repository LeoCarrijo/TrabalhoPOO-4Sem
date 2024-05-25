package lvpradoleonardo.com.veiculos;

import lvpradoleonardo.com.veiculos.model.entity.CarroEntity;
import lvpradoleonardo.com.veiculos.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    @Autowired
    CarroRepository injecao;
    public CarroEntity insere(CarroEntity carro) {
        return injecao.save(carro);
    }
}
