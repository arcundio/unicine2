package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.FacturaRepo;
import co.edu.uniquindio.unicine.repo.ProductoConfiteriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoConfiteriaTest {
    @Autowired
    private ProductoConfiteriaRepo productoConfiteriaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        ProductoConfiteria productoConfiteria = new ProductoConfiteria("Choclitos", "ruta_image", 8000);

        ProductoConfiteria guardado = productoConfiteriaRepo.save(productoConfiteria);

        Assertions.assertEquals("Choclitos", productoConfiteria.getNombre());
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {
        ProductoConfiteria guardado = productoConfiteriaRepo.findById(1).orElse(null);
        guardado.setPrecio(123);

        ProductoConfiteria nuevo = productoConfiteriaRepo.save(guardado);

        Assertions.assertEquals(123, nuevo.getPrecio());
    }

    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {

        ProductoConfiteria buscado = productoConfiteriaRepo.findById(1).orElse(null);
        productoConfiteriaRepo.delete(buscado);

        Assertions.assertNull( productoConfiteriaRepo.findById(1) );
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {

        ProductoConfiteria productoConfiteria = productoConfiteriaRepo.findById(1).orElse(null);

        Assertions.assertNotNull(productoConfiteria);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<ProductoConfiteria> lista = productoConfiteriaRepo.findAll();
        lista.forEach(System.out::println);
    }


}
