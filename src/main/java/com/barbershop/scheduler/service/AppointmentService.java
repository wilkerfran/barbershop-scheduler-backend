package com.barbershop.scheduler.service;

import com.barbershop.scheduler.model.Appointment;
import com.barbershop.scheduler.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment) {
        // 🔎 Verificação de conflito
    	if (appointmentRepository.existsByEmployee_IdAndDateTime(
    	        appointment.getEmployee().getId(),
    	        appointment.getDateTime())) {
    	    throw new RuntimeException("Já existe um agendamento para esse horário e funcionário.");
    	}

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }
}

