package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.entidades.Silla;
import co.edu.uniquindio.unicine.repo.SalaRepo;
import co.edu.uniquindio.unicine.repo.SillaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SillaTest {
    @Autowired
    private SillaRepo sillaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Silla> lista = sillaRepo.findAll();
        lista.forEach(System.out::println);
    }
}