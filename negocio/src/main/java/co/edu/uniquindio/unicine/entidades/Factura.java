package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
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
public class Factura implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private LocalDateTime fecha;

    @Positive
    private int total;
    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;


    @ManyToOne
    private Cliente cliente;

    @ToString.Exclude
    @OneToOne
    private Cupon cupon;

    @ToString.Exclude
    @OneToMany(mappedBy = "factura")
    private List<Entrada> entradas;

    @ManyToMany(mappedBy = "facturas")
    private List<ProductoConfiteria> productosConfiteria;

    @Builder
    public Factura(int total, MedioPago medioPago, Cliente cliente) {
        this.fecha = LocalDateTime.now();
        this.total = total;
        this.medioPago = medioPago;
        this.cliente = cliente;
    }
}
