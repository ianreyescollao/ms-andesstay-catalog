
package cl.mscatalogs.service.impl;

import cl.mscatalogs.dto.UnidadDTO;
import cl.mscatalogs.exception.NotFoundException;
import cl.mscatalogs.mapper.UnidadMapper;
import cl.mscatalogs.model.Establecimiento;
import cl.mscatalogs.model.Unidad;
import cl.mscatalogs.repository.EstablecimientoRepository;
import cl.mscatalogs.repository.UnidadRepository;
import cl.mscatalogs.service.CatalogoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    private final UnidadRepository unidadRepository;
    private final EstablecimientoRepository establecimientoRepository;
    private final UnidadMapper unidadMapper;

    public CatalogoServiceImpl(
            UnidadRepository unidadRepository,
            EstablecimientoRepository establecimientoRepository,
            UnidadMapper unidadMapper
    ) {
        this.unidadRepository = unidadRepository;
        this.establecimientoRepository = establecimientoRepository;
        this.unidadMapper = unidadMapper;
    }

    // LISTAR TODAS LAS UNIDADES
    @Override
    @Transactional(readOnly = true)
    public List<UnidadDTO> obtenerCatalogo() {

        return unidadRepository.findAll()
                .stream()
                .map(unidadMapper::toDTO)
                .toList();
    }

    // BUSCAR UNIDAD POR ID
    @Override
    @Transactional(readOnly = true)
    public UnidadDTO obtenerPorId(Long id) {

        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                "Unidad no encontrada: " + id
                        )
                );

        return unidadMapper.toDTO(unidad);
    }

    // CREAR UNIDAD
    @Override
    @Transactional
    public UnidadDTO crearUnidad(UnidadDTO dto) {

        Establecimiento establecimiento =
                establecimientoRepository.findById(
                        dto.idEstablecimiento()
                ).orElseThrow(() ->
                        new NotFoundException(
                                "Establecimiento no encontrado: "
                                        + dto.idEstablecimiento()
                        )
                );

        Unidad unidad = new Unidad();

        unidad.setNombre(dto.nombre());
        unidad.setDescripcion(dto.descripcion());
        unidad.setTipo(dto.tipo());
        unidad.setPrecio(dto.precio());
        unidad.setCapacidad(dto.capacidad());
        unidad.setDisponible(dto.disponible());
        unidad.setEstablecimiento(establecimiento);

        Unidad guardada = unidadRepository.save(unidad);

        return unidadMapper.toDTO(guardada);
    }

    // ACTUALIZAR UNIDAD
    @Override
    @Transactional
    public UnidadDTO actualizarUnidad(Long id, UnidadDTO dto) {

        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                "Unidad no encontrada: " + id
                        )
                );

        Establecimiento establecimiento =
                establecimientoRepository.findById(
                        dto.idEstablecimiento()
                ).orElseThrow(() ->
                        new NotFoundException(
                                "Establecimiento no encontrado: "
                                        + dto.idEstablecimiento()
                        )
                );

        unidad.setNombre(dto.nombre());
        unidad.setDescripcion(dto.descripcion());
        unidad.setTipo(dto.tipo());
        unidad.setPrecio(dto.precio());
        unidad.setCapacidad(dto.capacidad());
        unidad.setDisponible(dto.disponible());
        unidad.setEstablecimiento(establecimiento);

        Unidad actualizada = unidadRepository.save(unidad);

        return unidadMapper.toDTO(actualizada);
    }

    // ELIMINAR UNIDAD
    @Override
    @Transactional
    public void eliminarUnidad(Long id) {

        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                "Unidad no encontrada: " + id
                        )
                );

        unidadRepository.delete(unidad);
    }
}
