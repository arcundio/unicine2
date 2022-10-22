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
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;
    @NotNull
    private String nombre;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Departamento departamento;

    @ToString.Exclude
    @OneToMany(mappedBy="ciudad")
    private List<Teatro> teatros;

    @Builder
    public Ciudad(String nombre, Departamento departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }
}
