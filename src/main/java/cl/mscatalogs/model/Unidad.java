
package cl.mscatalogs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "unidad")
@Getter
@Setter
@NoArgsConstructor
public class Unidad {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "unidad_seq"
    )
    @SequenceGenerator(
            name = "unidad_seq",
            sequenceName = "UNIDAD_SEQ",
            allocationSize = 1
    )
    @Column(name = "id_unidad")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 20)
    private TipoUnidad tipo;

    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "disponible", nullable = false)
    private Boolean disponible = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_establecimiento", nullable = false)
    private Establecimiento establecimiento;
}
