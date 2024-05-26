package lvpradoleonardo.com.veiculos.controller;

import lvpradoleonardo.com.veiculos.model.dto.MotoDTO;
import lvpradoleonardo.com.veiculos.model.entity.MotoEntity;
import lvpradoleonardo.com.veiculos.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    MotoService injecao;
    @PostMapping
    public MotoDTO inserirMoto(@RequestBody MotoDTO moto) {
        return injecao.inserirMoto(moto);
    }

    @GetMapping
    public List<MotoDTO> consultarMotos() {
        return injecao.consultarMotos();
    }

    @GetMapping("/{id}")
    public MotoDTO consultarMoto(@PathVariable Long id) {
        return injecao.consultarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String removerMoto(@PathVariable Long id) {
        return injecao.removerMoto(id);
    }

    @PutMapping
    public List<MotoDTO> darDescontoGeral() {
        return injecao.darDescontoGeral();
    }
}
