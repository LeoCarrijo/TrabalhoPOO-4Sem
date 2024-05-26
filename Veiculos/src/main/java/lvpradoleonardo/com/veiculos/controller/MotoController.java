package lvpradoleonardo.com.veiculos.controller;

import lvpradoleonardo.com.veiculos.model.entity.MotoEntity;
import lvpradoleonardo.com.veiculos.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    MotoService injecao;
    @PostMapping
    public MotoEntity inserirMoto(MotoEntity moto) {
        return injecao.inserirMoto(moto);
    }
}