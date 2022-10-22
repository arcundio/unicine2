package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Sala implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @PositiveOrZero
    private int sillas_disponibles;

    @ManyToOne
    private Teatro teatro;

    @ToString.Exclude
    @OneToMany(mappedBy = "sala")
    private List<Silla> sillas;

    @Builder
    public Sala(int sillas_disponibles, Teatro teatro, List<Silla> sillas) {
        this.sillas_disponibles = sillas_disponibles;
        this.teatro = teatro;
        this.sillas = sillas;
    }
}
