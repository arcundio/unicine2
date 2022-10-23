package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, Integer> {

    @Query("select c from Administrador c where c.nombre = ?1")
    Administrador obtener(String nombre);
}
