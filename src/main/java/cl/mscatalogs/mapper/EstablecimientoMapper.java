
package cl.mscatalogs.mapper;

import cl.mscatalogs.dto.EstablecimientoDTO;
import cl.mscatalogs.model.Establecimiento;
import org.springframework.stereotype.Component;

@Component
public class EstablecimientoMapper {

    public EstablecimientoDTO toDTO(Establecimiento e) {
        if (e == null) return null;

        return new EstablecimientoDTO(
                e.getId(),
                e.getNombre(),
                e.getDireccion(),
                e.getActivo()
        );
    }
}
