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
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.gestionHotel.dto.ApiMessageResponse;
import com.cibertec.gestionHotel.dto.ReservaServiciosAdicionalesRequest;
import com.cibertec.gestionHotel.model.ReservaServiciosAdicionales;
import com.cibertec.gestionHotel.service.ReservaServiciosAdicionalesService;

@RestController
public class ReservaServiciosAdicionalesController {

    private final ReservaServiciosAdicionalesService reservaServiciosAdicionalesService;

    public ReservaServiciosAdicionalesController(
            ReservaServiciosAdicionalesService reservaServiciosAdicionalesService) {
        this.reservaServiciosAdicionalesService = reservaServiciosAdicionalesService;
    }

    @GetMapping("/reservas/{id}/servicios")
    public ResponseEntity<List<ReservaServiciosAdicionales>> listarPorReserva(@PathVariable Integer id) {
        return ResponseEntity.ok(reservaServiciosAdicionalesService.listarPorReserva(id));
    }

    @GetMapping("/reserva-servicios/{id}")
    public ResponseEntity<ReservaServiciosAdicionales> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(reservaServiciosAdicionalesService.obtenerPorId(id));
    }

    @PostMapping("/reserva-servicios")
    public ResponseEntity<ReservaServiciosAdicionales> crear(
            @RequestBody ReservaServiciosAdicionalesRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaServiciosAdicionalesService.crear(request));
    }

    @PutMapping("/reserva-servicios/{id}")
    public ResponseEntity<ReservaServiciosAdicionales> actualizar(@PathVariable Integer id,
            @RequestBody ReservaServiciosAdicionalesRequest request) {
        return ResponseEntity.ok(reservaServiciosAdicionalesService.actualizar(id, request));
    }

    @DeleteMapping("/reserva-servicios/{id}")
    public ResponseEntity<ApiMessageResponse> eliminar(@PathVariable Integer id) {
        reservaServiciosAdicionalesService.eliminar(id);
        return ResponseEntity.ok(new ApiMessageResponse("Servicio adicional de reserva eliminado correctamente"));
    }
}
