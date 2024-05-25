package lvpradoleonardo.com.veiculos.model.repository;

import lvpradoleonardo.com.veiculos.model.entity.CarroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroEntity, Long> {
    // esta interface vai herdar todos os métodos de CRUD
    // (Create, read, update, delete) de CarroEntity
    // não vamos precisar de escrever código SQL
    // teremos métodos prontos
}
