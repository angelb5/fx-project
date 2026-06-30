package com.fxproject.fxbackend.controller;

import com.fxproject.fxbackend.repository.FxOperacion;
import com.fxproject.fxbackend.service.FxOperacionDto;
import com.fxproject.fxbackend.service.FxOperacionEstadoDto;
import com.fxproject.fxbackend.service.FxOperacionService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FxController {

    private FxOperacionService service;

    public FxController(FxOperacionService service) {
        this.service = service;
    }

    @GetMapping("/api/fx/operaciones")
    public ResponseEntity<List<FxOperacion>> getOperaciones(@RequestParam(name = "estado") String estadoFilter) {
        return ResponseEntity.ok(service.getOperaciones(estadoFilter));
    }

    @PostMapping("/api/fx/operaciones")
    public ResponseEntity<FxOperacion> createOperacion(@Valid @RequestBody FxOperacionDto operacionDto) {
        return ResponseEntity.status(201).body(service.createOperacion(operacionDto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Boolean> updateOperacion(@PathVariable("id") int id, @Valid @RequestBody FxOperacionEstadoDto estadoDto) {
        return ResponseEntity.ok(service.updateOperacion(id, estadoDto));
    }
}
