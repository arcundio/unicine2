package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Silla {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @OneToOne(mappedBy = "silla")
    private Entrada entrada;

    @ManyToOne
    private Sala sala;

    @Builder
    public Silla(Sala sala) {
        this.sala = sala;
    }
}
