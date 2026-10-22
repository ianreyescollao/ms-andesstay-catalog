
package cl.mscatalogs.mapper;

import cl.mscatalogs.dto.UnidadDTO;
import cl.mscatalogs.model.Unidad;
import org.springframework.stereotype.Component;

@Component
public class UnidadMapper {

    public UnidadDTO toDTO(Unidad unidad) {

        if (unidad == null) {
            return null;
        }

        return new UnidadDTO(
                unidad.getId(),
                unidad.getNombre(),
                unidad.getDescripcion(),
                unidad.getTipo(),
                unidad.getPrecio(),
                unidad.getCapacidad(),
                unidad.getDisponible(),
                unidad.getEstablecimiento() != null
                        ? unidad.getEstablecimiento().getId()
                        : null
        );
    }
}
