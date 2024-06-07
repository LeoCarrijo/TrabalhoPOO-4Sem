package lvpradoleonardo.com.veiculos.controller;

import lvpradoleonardo.com.veiculos.model.dto.BarcoDTO;
import lvpradoleonardo.com.veiculos.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barco")
public class BarcoController {
    @Autowired
    BarcoService injecao;

    @PostMapping
    public BarcoDTO inserirBarco(@RequestBody BarcoDTO barco) {
        return injecao.insere(barco);
    }

    @GetMapping
    public List<BarcoDTO> consultarBarcos() {
        return injecao.consultarBarcos();
    }

    @DeleteMapping("/{id}")
    public String removerBarco(@PathVariable Long id) {
        return injecao.removerbarco(id);
    }

    @PutMapping
    public List<BarcoDTO> tranformarAltoMar() {
        return injecao.transformarAltoMar();
    }

    @PatchMapping("/{id}")
    public BarcoDTO atualizarBarco(@PathVariable Long id, @RequestBody BarcoDTO barco) {
        return injecao.atualizarPorId(barco, id);
    }
}
