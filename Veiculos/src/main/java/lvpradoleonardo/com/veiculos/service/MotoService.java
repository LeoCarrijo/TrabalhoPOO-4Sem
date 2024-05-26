package lvpradoleonardo.com.veiculos.service;

import lvpradoleonardo.com.veiculos.model.entity.MotoEntity;
import lvpradoleonardo.com.veiculos.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService {
    @Autowired
    MotoRepository injecao;
    public MotoEntity inserirMoto(MotoEntity moto) {
        return injecao.save(moto);
    }
}
