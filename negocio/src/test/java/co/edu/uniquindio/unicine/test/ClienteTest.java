package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar() {
        Cliente cliente = new Cliente(123, "Daniel", "ruta", "123", "31312190231", "correo@email.com");

        Cliente guardado = clienteRepo.save(cliente);

        Assertions.assertEquals("Luis", cliente.getNombre());
    }

    public void eliminar() {

    }

    public void actualizar() {

    }

    public void obtener() {

    }

    public void listar() {

    }
}
