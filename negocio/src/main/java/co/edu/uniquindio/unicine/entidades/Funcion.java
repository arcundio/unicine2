package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Funcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @NotNull
    private LocalDateTime horaInicial;

    @NotNull
    private LocalDateTime horaFinal;

    @ManyToOne
    private Pelicula pelicula;

    @ToString.Exclude
    @OneToMany(mappedBy = "funcion")
    private List<Entrada> entradas;

    @Builder
    public Funcion(LocalDateTime horaInicial, LocalDateTime horaFinal, Pelicula pelicula, List<Entrada> entradas) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.pelicula = pelicula;
        this.entradas = entradas;
    }
}
