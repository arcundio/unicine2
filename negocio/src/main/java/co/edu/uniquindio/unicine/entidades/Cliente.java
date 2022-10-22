package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cliente implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private int cedula;

    @NotNull
    private String nombre;

    @Column(nullable = false)
    private Boolean estado;

    private String imagen_perfil;

    @NotNull
    private String contrasena;

    @Column(nullable = false, length = 10)
    private String numero_telefono;

    @Column(nullable = false)
    @Email
    private String email;

    @OneToOne(mappedBy = "cliente")
    private Factura factura;

    @Builder
    public Cliente(int cedula, String nombre, String imagen_perfil, String contrasena, String numero_telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.imagen_perfil = imagen_perfil;
        this.contrasena = contrasena;
        this.numero_telefono = numero_telefono;
        this.email = email;
        this.estado = false;
    }
}
