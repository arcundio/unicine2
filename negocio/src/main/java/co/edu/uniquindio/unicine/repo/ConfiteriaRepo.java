package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.ProductoConfiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiteriaRepo extends JpaRepository<ProductoConfiteria, Integer> {
}
