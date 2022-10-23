package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.ProductoConfiteriaRepo;
import co.edu.uniquindio.unicine.repo.TeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeatroTest {
    @Autowired
    private TeatroRepo teatroRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Administrador admin= new Administrador("Pepo peposo", "123"  );
        Ciudad ciudad= new Ciudad("Armenia", Departamento.QUINDIO);
        Teatro teatro = new Teatro("Masacuato", admin , ciudad);

        Teatro guardado = teatroRepo.save(teatro);

        Assertions.assertEquals("Masacuato", guardado.getNombre());
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {
        Teatro guardado = teatroRepo.findById(1).orElse(null);
        guardado.setNombre("Teatro los más usureros");

        Teatro nuevo = teatroRepo.save(guardado);

        Assertions.assertEquals("Teatro los más usureros", nuevo.getNombre());
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {

        Teatro buscado = teatroRepo.findById(1).orElse(null);
        teatroRepo.delete(buscado);

        Assertions.assertNull( teatroRepo.findById(1).orElse(null) );
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {

        Teatro teatro = teatroRepo.findById(2).orElse(null);

        Assertions.assertNotNull(teatro);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Teatro> lista = teatroRepo.findAll();
        lista.forEach(System.out::println);
    }

}
