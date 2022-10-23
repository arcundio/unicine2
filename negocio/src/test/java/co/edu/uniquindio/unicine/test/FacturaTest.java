package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturaTest {

    @Autowired
    private FacturaRepo facturaRepo;
    @Autowired
    private EntradaRepo entradaRepo;
    @Autowired
    private ProductoConfiteriaRepo productoConfiteriaRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private CuponRepo cuponRepo;


    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {
        List<Factura> lista = facturaRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void realizarCompra() {

        Entrada entrada = entradaRepo.findById(1).orElse(null);
        ProductoConfiteria productoConfiteria = productoConfiteriaRepo.findById(1).orElse(null);
        Cliente cliente = clienteRepo.findById(1213).orElse(null);

        Assertions.assertNotNull(entrada);
        Assertions.assertNotNull(productoConfiteria);
        Assertions.assertNotNull(cliente);

        int total = entrada.getPrecio() + productoConfiteria.getPrecio();

        Factura factura = new Factura(total, MedioPago.DAVIPLATA, cliente);

        Factura guardado = facturaRepo.save(factura);

        Assertions.assertNotNull(guardado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void redimirCupon() {

        Cupon cupon = cuponRepo.findById(20).orElse(null);
        Factura factura = facturaRepo.findById(1).orElse(null);

        Assertions.assertNotNull(cupon);
        Assertions.assertNotNull(factura);

        factura.setCupon(cupon);
        factura.setTotal((int) Math.round(factura.getTotal()*factura.getCupon().getValor_descuento()));

        Factura guardado = facturaRepo.save(factura);

        Assertions.assertEquals(cupon, guardado.getCupon());

    }
    @Sql("classpath:dataset.sql")
    @Test
    public void listarCompras() {

        Cliente cliente = clienteRepo.findById(1213).orElse(null);

        Assertions.assertNotNull(cliente);

        List<Factura> facturas = cliente.getFacturas();

        facturas.forEach(System.out::println);

    }

}
