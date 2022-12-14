package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
    @Query("select c from Cliente c where c.email = ?1")
    Cliente obtener(String nombre);
}
