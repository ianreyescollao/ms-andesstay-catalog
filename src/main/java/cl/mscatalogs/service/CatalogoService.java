package cl.mscatalogs.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CatalogoService {

    public List<Map<String, Object>> obtenerCatalogo() {
        return List.of(
                Map.of(
                        "id", 1,
                        "nombre", "Habitacion Standard",
                        "precio", 45000
                ),
                Map.of(
                        "id", 2,
                        "nombre", "Habitacion Premium",
                        "precio", 75000
                ),
                Map.of(
                        "id", 3,
                        "nombre", "Suite Andes",
                        "precio", 120000
                )
        );
    }
}