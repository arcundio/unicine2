package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Entrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Positive
    @NotNull
    private int precio;

    @ManyToOne
    private Funcion funcion;

    @OneToOne
    private Silla silla;

    @ManyToOne
    private Factura factura;

    @Builder
    public Entrada(int precio, Funcion funcion, Silla silla) {
        this.precio = precio;
        this.funcion = funcion;
        this.silla = silla;
    }
}
