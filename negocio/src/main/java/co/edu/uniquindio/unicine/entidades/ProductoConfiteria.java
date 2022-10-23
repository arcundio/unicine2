package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoConfiteria implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @NotNull
    private String nombre;

    @NotNull
    private String imagen;

    @Max(100000)
    private int precio;

    @ToString.Exclude
    @ManyToMany
    private List<Factura> facturas;

    @Builder
    public ProductoConfiteria(String nombre, String imagen, int precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }
}
