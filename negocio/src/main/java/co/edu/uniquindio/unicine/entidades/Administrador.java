package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Administrador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private String nombre; // este es equivalente a usuario

    @Column(nullable = false)
    private String contrasena;

    @ToString.Exclude
    @OneToMany(mappedBy = "administrador")
    private List<Teatro> teatros;

    @Builder
    public Administrador(String nombre, String contrasena) {
        this.contrasena = contrasena;
        this.nombre = nombre;
    }
}
