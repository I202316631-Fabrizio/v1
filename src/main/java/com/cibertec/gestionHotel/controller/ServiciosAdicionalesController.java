package com.cibertec.gestionHotel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.gestionHotel.dto.ApiMessageResponse;
import com.cibertec.gestionHotel.model.ServiciosAdicionales;
import com.cibertec.gestionHotel.service.ServiciosAdicionalesService;

@RestController
@RequestMapping("/servicios")
public class ServiciosAdicionalesController {

    private final ServiciosAdicionalesService serviciosAdicionalesService;

    public ServiciosAdicionalesController(ServiciosAdicionalesService serviciosAdicionalesService) {
        this.serviciosAdicionalesService = serviciosAdicionalesService;
    }

    @GetMapping
    public ResponseEntity<List<ServiciosAdicionales>> listarTodos() {
        return ResponseEntity.ok(serviciosAdicionalesService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiciosAdicionales> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(serviciosAdicionalesService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ServiciosAdicionales> crear(@RequestBody ServiciosAdicionales servicio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviciosAdicionalesService.crear(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiciosAdicionales> actualizar(@PathVariable Integer id,
            @RequestBody ServiciosAdicionales servicio) {
        return ResponseEntity.ok(serviciosAdicionalesService.actualizar(id, servicio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiMessageResponse> eliminar(@PathVariable Integer id) {
        serviciosAdicionalesService.eliminar(id);
        return ResponseEntity.ok(new ApiMessageResponse("Servicio adicional eliminado correctamente"));
    }
}
