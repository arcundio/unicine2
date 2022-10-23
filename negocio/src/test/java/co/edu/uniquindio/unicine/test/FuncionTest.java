package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {

    @Autowired
    private FuncionRepo funcionRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Pelicula pelicula = new Pelicula("Frozen", "ruta_imagen", "ruta_trailer", Genero.DRAMA, "una mujercita");

        Funcion funcion = new Funcion(LocalDateTime.of(2022, 10, 22, 2, 20, 0),
                LocalDateTime.of(2022, 10, 22, 4, 20, 0), pelicula);

        Funcion guardado = funcionRepo.save(funcion);

        Assertions.assertEquals(pelicula, funcion.getPelicula());
    }
    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {

        Funcion buscado = funcionRepo.findById(1).orElse(null);
        funcionRepo.delete(buscado);

        Assertions.assertNull( funcionRepo.findById(1).orElse(null));


    }
    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {

        Funcion guardado = funcionRepo.findById(1).orElse(null);
        guardado.setHoraInicial(LocalDateTime.of(2022, 10, 22, 6, 40, 0));

        Funcion nuevo = funcionRepo.save(guardado);

        Assertions.assertEquals(LocalDateTime.of(2022, 10, 22, 6, 40, 0), nuevo.getHoraInicial());
    }
    @Sql("classpath:dataset.sql")
    @Test
    public void obtener() {

        Funcion buscado = funcionRepo.findById(1).orElse(null);

        Assertions.assertNotNull(buscado);

    }

    @Sql("classpath:dataset.sql")
    @Test
    public void listar() {
        List<Funcion> lista = funcionRepo.findAll();
        lista.forEach(System.out::println);
    }

}
