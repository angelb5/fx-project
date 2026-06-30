package com.fxproject.fxbackend.service;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class FxOperacionDto {
    private int id;
    @NotNull
    @Size(max = 3)
    private String monedaOrigen;
    @NotNull
    @Size(max = 3)
    private String monedaDestino;
    @NotNull
    @Positive
    private double montoOrigen;
    @NotNull
    @Positive
    private double tipoCambio;
    @NotNull
    @Pattern(regexp = "^(?:PENDIENTE|EJECUTADA|ANULADA)$")
    @NotNull
    private String estado;
    @NotNull
    private LocalDate fechaOperacion;
    private Instant createdAt;
}
