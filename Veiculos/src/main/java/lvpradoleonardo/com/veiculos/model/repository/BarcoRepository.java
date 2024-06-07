package lvpradoleonardo.com.veiculos.model.repository;

import lvpradoleonardo.com.veiculos.model.entity.BarcoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcoRepository extends JpaRepository<BarcoEntity, Long> {
}
