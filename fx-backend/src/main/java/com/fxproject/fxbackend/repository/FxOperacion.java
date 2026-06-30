package com.fxproject.fxbackend.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
public class FxOperacion {
    @Id
    private int id;
    private String monedaOrigen;
    private String monedaDestino;
    private double montoOrigen;
    @GeneratedValue
    @Column(insertable = false, updatable = false)
    private double montoDestino;
    private double tipoCambio;
    private String estado;
    private LocalDate fechaOperacion;
    private Instant createdAt;
}
