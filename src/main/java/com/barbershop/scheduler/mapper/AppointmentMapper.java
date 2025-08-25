package com.barbershop.scheduler.mapper;

import com.barbershop.scheduler.dto.AppointmentDTO;
import com.barbershop.scheduler.model.Appointment;

public class AppointmentMapper {

    public static AppointmentDTO toDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getDateTime(),
                appointment.getServiceType(),
                appointment.getClient().getName(),
                appointment.getEmployee().getName()
        );
    }

    // Se precisar, podemos criar toEntity também
    // public static Appointment toEntity(AppointmentDTO dto) { ... }
}
