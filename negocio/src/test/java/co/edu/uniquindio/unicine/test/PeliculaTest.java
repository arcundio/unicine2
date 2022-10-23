package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {
    @Autowired
    private PeliculaRepo peliculaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Pelicula pelicula = new Pelicula("Frozen", "ruta_imagen", "ruta_trailer", Genero.DRAMA, "una mujercita");

        Pelicula guardado = peliculaRepo.save(pelicula);

        Assertions.assertEquals("Frozen", pelicula.getNombre());
    }
    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {

        Pelicula buscado = peliculaRepo.findById(200).orElse(null);
        peliculaRepo.delete(buscado);

        Assertions.assertNull( peliculaRepo.findById(200).orElse(null) );


    }
    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {

        Pelicula guardado = peliculaRepo.findById(1213).orElse(null);
        guardado.setNombre("Clockwork Orange");

        Pelicula nuevo = peliculaRepo.save(guardado);

        Assertions.assertEquals("Clockwork Orange", nuevo.getNombre());
    }
    @Sql("classpath:dataset.sql")
    @Test
    public void obtener() {

        Optional<Pelicula> buscado = peliculaRepo.findById(200);

        Assertions.assertNotNull(buscado.orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Pelicula> lista = peliculaRepo.findAll();
        lista.forEach(System.out::println);
    }

    // Cliente
    @Sql("classpath:dataset.sql")
    @Test
    public void buscarPorNombre() {
        Pelicula buscada = peliculaRepo.obtener("Top Gun");

        Assertions.assertNotNull(buscada);
    }
}
