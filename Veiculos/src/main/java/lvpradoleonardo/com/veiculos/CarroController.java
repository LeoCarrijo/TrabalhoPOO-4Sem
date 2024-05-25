package lvpradoleonardo.com.veiculos;

import lvpradoleonardo.com.veiculos.model.entity.CarroEntity;
import lvpradoleonardo.com.veiculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    CarroService injecao;
    @PostMapping
    public CarroEntity inserirCarro(@RequestBody CarroEntity carro) {
        return injecao.insere(carro);
    }
}
