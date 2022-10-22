package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Teatro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nombre;

    @ManyToOne
    private Administrador administrador;

    @ManyToOne
    private Ciudad ciudad;

    @ToString.Exclude
    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas;

    @Builder
    public Teatro(String nombre, Administrador administrador, Ciudad ciudad) {
        this.nombre = nombre;
        this.administrador = administrador;
        this.ciudad = ciudad;
    }
}
