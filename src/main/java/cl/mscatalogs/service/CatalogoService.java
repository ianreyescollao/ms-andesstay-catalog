
package cl.mscatalogs.service;

import cl.mscatalogs.dto.UnidadDTO;
import java.util.List;

public interface CatalogoService {

    List<UnidadDTO> obtenerCatalogo();
    UnidadDTO obtenerPorId(Long id);
    UnidadDTO crearUnidad(UnidadDTO unidadDTO);
    UnidadDTO actualizarUnidad(Long id, UnidadDTO unidadDTO);
    void eliminarUnidad(Long id);
}
