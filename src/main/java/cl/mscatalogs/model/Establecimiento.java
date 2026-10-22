
package cl.mscatalogs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "establecimiento")
@Getter
@Setter
@NoArgsConstructor
public class Establecimiento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "establecimiento_seq"
    )
    @SequenceGenerator(
            name = "establecimiento_seq",
            sequenceName = "ESTABLECIMIENTO_SEQ",
            allocationSize = 1
    )
    @Column(name = "id_establecimiento")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @OneToMany(mappedBy = "establecimiento", fetch = FetchType.LAZY)
    private List<Unidad> unidades = new ArrayList<>();
}
