package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.ProductoConfiteria;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuponTest {

    @Autowired
    private CuponRepo cuponRepo;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Cupon productoConfiteria = new Cupon(0.95, LocalDate.of(2023, Month.APRIL,1), "Cupón por aniversario del establecimiento","Por ser un cliente leal");

        Cupon guardado = cuponRepo.save(productoConfiteria);

        Assertions.assertEquals("Cupón por aniversario del establecimiento", productoConfiteria.getDescripcion());
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {
        Cupon guardado = cuponRepo.findById(20).orElse(null);
        guardado.setDescripcion("Por el 50 aniversario del establecimiento");

        Cupon nuevo = cuponRepo.save(guardado);

        Assertions.assertEquals("Por el 50 aniversario del establecimiento", nuevo.getDescripcion());
    }


    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {
        Cupon buscado = cuponRepo.findById(20).orElse(null);
        cuponRepo.delete(buscado);

        Assertions.assertNull( cuponRepo.findById(20).orElse(null) );
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {

        Cupon cupon = cuponRepo.findById(21).orElse(null);

        Assertions.assertNotNull(cupon);


    }


    @Sql("classpath:dataset.sql")
    @Test
    public void listar() {
        List<Cupon> lista = cuponRepo.findAll();
        lista.forEach(System.out::println);
    }
}
