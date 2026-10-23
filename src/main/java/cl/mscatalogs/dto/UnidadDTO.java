
package cl.mscatalogs.dto;

import cl.mscatalogs.model.TipoUnidad;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record UnidadDTO(

        Long id,

        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        String descripcion,

        @NotNull(message = "El tipo de unidad es obligatorio")
        TipoUnidad tipo,

        @NotNull(message = "El precio es obligatorio")
        @PositiveOrZero(message = "El precio no puede ser negativo")
        BigDecimal precio,

        @NotNull(message = "La capacidad es obligatoria")
        @Min(value = 1, message = "La capacidad debe ser al menos 1")
        Integer capacidad,

        @NotNull(message = "La disponibilidad es obligatoria")
        Boolean disponible,

        @NotNull(message = "El establecimiento es obligatorio")
        Long idEstablecimiento

) {
}
