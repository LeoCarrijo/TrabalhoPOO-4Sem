package lvpradoleonardo.com.veiculos.controller;

import lvpradoleonardo.com.veiculos.model.dto.CarroDTO;
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
    public CarroDTO inserirCarro(@RequestBody CarroDTO carroDTO) {
        return injecao.insere(carroDTO);
    }
}
