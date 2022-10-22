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
public class Pelicula implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @NotNull
    private String nombre;

    @NotNull
    private String direccion_imagen;

    @NotNull
    private String direccion_trailer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @NotNull
    private String sinopsis;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

    @Builder
    public Pelicula(String nombre, String direccion_imagen, String direccion_trailer, Genero genero, String sinopsis) {
        this.nombre = nombre;
        this.direccion_imagen = direccion_imagen;
        this.direccion_trailer = direccion_trailer;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }
}
