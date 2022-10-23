package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import co.edu.uniquindio.unicine.repo.SalaRepo;
import co.edu.uniquindio.unicine.repo.SillaRepo;
import co.edu.uniquindio.unicine.repo.TeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SalaTest {

    @Autowired
    private SalaRepo salaRepo;
    @Autowired
    private TeatroRepo teatroRepo;
    @Autowired
    private SillaRepo sillaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Sala sala = new Sala();
        Teatro teatro = teatroRepo.findById(1).orElse(null);
        Silla silla1 = new Silla();
        Silla silla2 = new Silla();
        ArrayList<Silla> sillas = new ArrayList<Silla>();
        sillas.add(silla1);
        sillas.add(silla2);
        sala.setSillas_disponibles(sillas.size());
        sala.setTeatro(teatro);
        sala.setSillas(sillas);

        for (Silla s : sala.getSillas()) {
            s.setSala(sala);
        }

        for (Silla s : sala.getSillas()) {
            System.out.println(s);
        }

        Sala nueva = salaRepo.save(sala);

        Assertions.assertNotNull(nueva);

    }

    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {
        Sala sala = salaRepo.findById(1).orElse(null);
        sala.setSillas_disponibles(43);

        Sala guardado = salaRepo.save(sala);

        Assertions.assertEquals(43, sala.getSillas_disponibles());
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {
        Sala buscado = salaRepo.findById(1).orElse(null);
        salaRepo.delete(buscado);

        Assertions.assertNull( salaRepo.findById(1).orElse(null) );
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {
        Optional<Sala> buscado = salaRepo.findById(2);

        Assertions.assertNotNull(buscado.orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Sala> lista = salaRepo.findAll();
        lista.forEach(System.out::println);
    }
}
