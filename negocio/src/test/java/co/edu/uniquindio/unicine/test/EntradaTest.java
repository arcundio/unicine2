package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.entidades.Silla;
import co.edu.uniquindio.unicine.repo.EntradaRepo;
import co.edu.uniquindio.unicine.repo.SillaRepo;
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
public class EntradaTest {
    @Autowired
    private EntradaRepo entradaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Entrada> lista = entradaRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void obtener() {

        Entrada buscado = entradaRepo.findById(1).orElse(null);

        System.out.println(buscado.getSilla());

    }
}