package co.edu.uniquindio.unicine.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cupon implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Positive
    private double valor_descuento;

    private LocalDate fecha_vencimiento;

    private String descripcion;

    private String criterio;

    @OneToOne(mappedBy = "cupon")
    private Factura factura;

    @Builder
    public Cupon(double valor_descuento, LocalDate fecha_vencimiento, String descripcion, String criterio) {
        this.valor_descuento = valor_descuento;
        this.fecha_vencimiento = fecha_vencimiento;
        this.descripcion = descripcion;
        this.criterio = criterio;
    }
}
