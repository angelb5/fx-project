package com.fxproject.fxbackend.service;

import com.fxproject.fxbackend.repository.FxOperacion;
import com.fxproject.fxbackend.repository.FxOperacionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class FxOperacionService {

    private FxOperacionRepository repository;

    private FxOperacionService(FxOperacionRepository repository) {
        this.repository = repository;
    }

    public List<FxOperacion> getOperaciones(String estadoFilter) {
        List<FxOperacion> operaciones;

        if (estadoFilter != null & !estadoFilter.isEmpty()) {
            operaciones = repository.findAllByEstado(estadoFilter);
        } else {
            operaciones = repository.findAll();
        }

        return operaciones;
    }

    public FxOperacion createOperacion(FxOperacionDto fxOperacionDto) {
        if (fxOperacionDto.getMonedaOrigen().equalsIgnoreCase(fxOperacionDto.getMonedaDestino())) {
            throw new FxCreationException("Las monedas deben ser de distintos tipos");
        }

        var operacion = mapOperacionDtoToOperacion(fxOperacionDto);
        operacion.setCreatedAt(Instant.now());

        return repository.save(operacion);
    }

    public boolean updateOperacion(int id, FxOperacionEstadoDto estadoDto) {
        var operacionOptional = repository.findById(id);
        if (operacionOptional.isEmpty() ) {
            throw new FxUpdateException("Id de operación inválido");
        }

        var operacion = operacionOptional.get();

        if (operacion.getEstado().equalsIgnoreCase("ANULADA")) {
            throw new FxUpdateException("No se puede editar una operacion anulada");
        }

        operacion.setEstado(estadoDto.estado);

        repository.save(operacion);

        return true;
    }

    private FxOperacionDto mapOperacionToOperacionDto(FxOperacion operacion) {
        var dto =  new FxOperacionDto();
        dto.setId(operacion.getId());
        dto.setMonedaOrigen(operacion.getMonedaOrigen());
        dto.setMonedaDestino(operacion.getMonedaDestino());
        dto.setMontoOrigen(operacion.getMontoOrigen());
        dto.setTipoCambio(operacion.getTipoCambio());
        dto.setEstado(operacion.getEstado());
        dto.setFechaOperacion(operacion.getFechaOperacion());
        dto.setCreatedAt(operacion.getCreatedAt());
        return dto;
    }

    private FxOperacion mapOperacionDtoToOperacion(FxOperacionDto dto) {
        var operacion = new FxOperacion();
        operacion.setId(dto.getId());
        operacion.setMonedaOrigen(dto.getMonedaOrigen());
        operacion.setMonedaDestino(dto.getMonedaDestino());
        operacion.setMontoOrigen(dto.getMontoOrigen());
        operacion.setTipoCambio(dto.getTipoCambio());
        operacion.setEstado(dto.getEstado());
        operacion.setFechaOperacion(dto.getFechaOperacion());
        return operacion;
    }
}
