package lvpradoleonardo.com.veiculos.model.repository;

import lvpradoleonardo.com.veiculos.model.entity.MotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<MotoEntity, Long> {
    
}
