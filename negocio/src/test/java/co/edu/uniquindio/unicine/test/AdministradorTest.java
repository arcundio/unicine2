package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.Assert;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {
    @Autowired
    private AdministradorRepo administradorRepo;

    @Sql("classpath:dataset.sql")
    @Test
    public void listar() {
        List<Administrador> lista = administradorRepo.findAll();
        lista.forEach(System.out::println);
    }

    // Loguearse administrador
    @Test
    @Sql("classpath:dataset.sql")
    public void login() {

        String usuario = "admin1";
        String contrasena = "admin1";

        Administrador buscado = administradorRepo.obtener(usuario);

        Assertions.assertNotNull(buscado);

        Assertions.assertEquals(contrasena, buscado.getContrasena());

        System.out.println(buscado);

    }
}

