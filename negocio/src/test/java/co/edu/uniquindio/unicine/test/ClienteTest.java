package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    // Método prueba para registrarse por primera vez
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarse() {

        int cedula = 7541542;
        String nombre = "Pepito Perez";
        String ruta_perfil = "ruta_image";
        String contrasena = "password1234";
        String numero_telefono = "3215152129";
        String correo = "pepito@email.com";
        boolean estado = false;

        Cliente cliente = new Cliente(cedula, nombre, ruta_perfil, contrasena, numero_telefono, correo);

        Cliente guardado  = clienteRepo.save(cliente);

        Assertions.assertNotNull(guardado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void login() {
        String email = "jake@email.com";
        String contrasena = "dino123";

        Cliente buscado = clienteRepo.obtener(email);

        Assertions.assertNotNull(buscado);

        Assertions.assertEquals(contrasena, buscado.getContrasena());

        System.out.println(buscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Cliente cliente = new Cliente(123, "Daniel", "ruta", "123", "31312190231", "correo@email.com");

        Cliente guardado = clienteRepo.save(cliente);

        Assertions.assertEquals("Luis", cliente.getNombre());
    }
    @Sql("classpath:dataset.sql")
    @Test
    public void eliminar() {

        Cliente buscado = clienteRepo.findById(1213).orElse(null);
        clienteRepo.delete(buscado);

        Assertions.assertNull( clienteRepo.findById(1213).orElse(null) );


    }
    @Sql("classpath:dataset.sql")
    @Test
    public void actualizar() {

        Cliente guardado = clienteRepo.findById(1213).orElse(null);
        guardado.setEmail("jake_nuevo@email.com");

        Cliente nuevo = clienteRepo.save(guardado);

        Assertions.assertEquals("jake_nuevo@email.com", nuevo.getEmail());
    }
    @Sql("classpath:dataset.sql")
    @Test
    public void obtener() {

        Optional<Cliente> buscado = clienteRepo.findById(1213);

        Assertions.assertNotNull(buscado.orElse(null));

    }
    @Sql("classpath:dataset.sql")
    @Test
    public void listar() {
        List<Cliente> lista = clienteRepo.findAll();
        lista.forEach(System.out::println);
    }
}
