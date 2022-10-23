package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {
    @Query("select c from Pelicula c where c.nombre = ?1")
    Pelicula obtener(String nombre);

}
