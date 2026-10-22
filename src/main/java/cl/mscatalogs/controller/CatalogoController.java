
package cl.mscatalogs.controller;
import jakarta.validation.Valid;
import cl.mscatalogs.dto.UnidadDTO;
import cl.mscatalogs.service.CatalogoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/units")
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    // LISTAR TODAS LAS UNIDADES
    @GetMapping
    public ResponseEntity<List<UnidadDTO>> obtenerCatalogo() {
        return ResponseEntity.ok(catalogoService.obtenerCatalogo());
    }

    // BUSCAR UNIDAD POR ID
    @GetMapping("/{id}")
    public ResponseEntity<UnidadDTO> obtenerPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(catalogoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<UnidadDTO> crearUnidad(
            @Valid @RequestBody UnidadDTO unidadDTO
    ) {
        UnidadDTO creada = catalogoService.crearUnidad(unidadDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadDTO> actualizarUnidad(
            @PathVariable Long id,
            @Valid @RequestBody UnidadDTO unidadDTO
    ) {
        return ResponseEntity.ok(
                catalogoService.actualizarUnidad(id, unidadDTO)
        );
    }

    // ELIMINAR UNIDAD
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUnidad(
            @PathVariable Long id
    ) {
        catalogoService.eliminarUnidad(id);

        return ResponseEntity.noContent().build();
    }
}
