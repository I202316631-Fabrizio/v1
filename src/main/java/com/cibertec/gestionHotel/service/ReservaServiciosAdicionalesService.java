package com.cibertec.gestionHotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.gestionHotel.dto.ReservaServiciosAdicionalesRequest;
import com.cibertec.gestionHotel.exception.BadRequestException;
import com.cibertec.gestionHotel.exception.ResourceNotFoundException;
import com.cibertec.gestionHotel.model.ReservaServiciosAdicionales;
import com.cibertec.gestionHotel.model.Reservas;
import com.cibertec.gestionHotel.model.ServiciosAdicionales;
import com.cibertec.gestionHotel.repository.ReservaServiciosAdicionalesRepository;
import com.cibertec.gestionHotel.repository.ReservasRepository;
import com.cibertec.gestionHotel.repository.ServiciosAdicionalesRepository;

@Service
public class ReservaServiciosAdicionalesService {

    private final ReservaServiciosAdicionalesRepository reservaServiciosAdicionalesRepository;
    private final ReservasRepository reservasRepository;
    private final ServiciosAdicionalesRepository serviciosAdicionalesRepository;

    public ReservaServiciosAdicionalesService(
            ReservaServiciosAdicionalesRepository reservaServiciosAdicionalesRepository,
            ReservasRepository reservasRepository,
            ServiciosAdicionalesRepository serviciosAdicionalesRepository) {
        this.reservaServiciosAdicionalesRepository = reservaServiciosAdicionalesRepository;
        this.reservasRepository = reservasRepository;
        this.serviciosAdicionalesRepository = serviciosAdicionalesRepository;
    }

    @Transactional(readOnly = true)
    public List<ReservaServiciosAdicionales> listarPorReserva(Integer idReserva) {
        validarReservaExiste(idReserva);
        return reservaServiciosAdicionalesRepository.findByReservaIdReserva(idReserva);
    }

    @Transactional(readOnly = true)
    public ReservaServiciosAdicionales obtenerPorId(Integer id) {
        return reservaServiciosAdicionalesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Servicio adicional de reserva no encontrado con id: " + id));
    }

    @Transactional
    public ReservaServiciosAdicionales crear(ReservaServiciosAdicionalesRequest request) {
        ReservaServiciosAdicionales reservaServicio = new ReservaServiciosAdicionales();
        reservaServicio.setIdReservaServicio(null);
        completarDatos(reservaServicio, request);

        return reservaServiciosAdicionalesRepository.save(reservaServicio);
    }

    @Transactional
    public ReservaServiciosAdicionales actualizar(Integer id, ReservaServiciosAdicionalesRequest request) {
        ReservaServiciosAdicionales reservaServicio = obtenerPorId(id);
        completarDatos(reservaServicio, request);

        return reservaServiciosAdicionalesRepository.save(reservaServicio);
    }

    @Transactional
    public void eliminar(Integer id) {
        ReservaServiciosAdicionales reservaServicio = obtenerPorId(id);
        reservaServiciosAdicionalesRepository.delete(reservaServicio);
    }

    private void completarDatos(ReservaServiciosAdicionales reservaServicio,
            ReservaServiciosAdicionalesRequest request) {
        if (request.getIdReserva() == null) {
            throw new BadRequestException("El idReserva es obligatorio");
        }
        if (request.getIdServicioAdicional() == null) {
            throw new BadRequestException("El idServicioAdicional es obligatorio");
        }
        if (request.getPrecioUnitario() == null) {
            throw new BadRequestException("El precioUnitario es obligatorio");
        }
        if (request.getCantidad() == null) {
            throw new BadRequestException("La cantidad es obligatoria");
        }

        Reservas reserva = reservasRepository.findById(request.getIdReserva())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Reserva no encontrada con id: " + request.getIdReserva()));

        ServiciosAdicionales servicioAdicional = serviciosAdicionalesRepository.findById(request.getIdServicioAdicional())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Servicio adicional no encontrado con id: " + request.getIdServicioAdicional()));

        reservaServicio.setReserva(reserva);
        reservaServicio.setServicioAdicional(servicioAdicional);
        reservaServicio.setCantidad(request.getCantidad());
        reservaServicio.setPrecioUnitario(request.getPrecioUnitario());
    }

    private void validarReservaExiste(Integer idReserva) {
        if (!reservasRepository.existsById(idReserva)) {
            throw new ResourceNotFoundException("Reserva no encontrada con id: " + idReserva);
        }
    }
}
