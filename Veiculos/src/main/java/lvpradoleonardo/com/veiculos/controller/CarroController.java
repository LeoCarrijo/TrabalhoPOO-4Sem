package lvpradoleonardo.com.veiculos.controller;

import lvpradoleonardo.com.veiculos.model.dto.CarroDTO;
import lvpradoleonardo.com.veiculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    CarroService injecao;
    @PostMapping
    public CarroDTO inserirCarro(@RequestBody CarroDTO carroDTO) {
        return injecao.insere(carroDTO);
    }

    @GetMapping
    public List<CarroDTO> consultarCarros() {
        return injecao.consultarCarros();
    }

    @GetMapping("/{id}")
    public CarroDTO consultarPorId(@PathVariable Long id) {
        return injecao.consultarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String removerCarro(@PathVariable Long id) {
        return injecao.removerCarro(id);
    }

    @PutMapping
    public List<CarroDTO> darDescontoGeral() {
        return injecao.darDescontoGeral();
    }

    @PatchMapping("/{id}")
    public CarroDTO atualizarPorId(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        return injecao.atualizarPorId(id, carroDTO);
    }
}
