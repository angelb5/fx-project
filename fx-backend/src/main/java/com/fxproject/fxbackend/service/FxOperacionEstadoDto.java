package com.fxproject.fxbackend.service;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FxOperacionEstadoDto {
    @NotNull
    String estado;
}
