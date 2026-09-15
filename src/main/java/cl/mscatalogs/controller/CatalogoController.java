package cl.mscatalogs.controller;

import cl.mscatalogs.service.CatalogoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/catalog")
public class CatalogoController {

    private final CatalogoService catalogService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogService = catalogoService;
    }

    @GetMapping
    public List<Map<String, Object>> obtenerCatalogo() {
        return catalogService.obtenerCatalogo();
    }
}