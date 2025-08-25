package com.barbershop.scheduler.controller;

import com.barbershop.scheduler.dto.AppointmentDTO;
import com.barbershop.scheduler.dto.AppointmentRequestDTO;
import com.barbershop.scheduler.mapper.AppointmentMapper;
import com.barbershop.scheduler.model.Appointment;
import com.barbershop.scheduler.model.User;
import com.barbershop.scheduler.service.AppointmentService;
import com.barbershop.scheduler.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;

    public AppointmentController(AppointmentService appointmentService, UserService userService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
    }

    @PostMapping
    public AppointmentDTO createAppointment(@RequestBody AppointmentRequestDTO dto) {
        User client = userService.getUserById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        User employee = userService.getUserById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Appointment appointment = new Appointment();
        appointment.setDateTime(dto.getDateTime());
        appointment.setServiceType(dto.getServiceType());
        appointment.setClient(client);
        appointment.setEmployee(employee);

        Appointment saved = appointmentService.saveAppointment(appointment);

        return AppointmentMapper.toDTO(saved);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id)
                .map(this::toDTO);
    }

    // ✅ Conversão centralizada
    private AppointmentDTO toDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getDateTime(),
                appointment.getServiceType(),
                appointment.getClient().getName(),
                appointment.getEmployee().getName()
        );
    }
}
