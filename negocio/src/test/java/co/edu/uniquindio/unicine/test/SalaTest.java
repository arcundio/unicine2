package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import co.edu.uniquindio.unicine.repo.SalaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SalaTest {

    @Autowired
    private SalaRepo salaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

    }

    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {

    }

    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

    }
}
