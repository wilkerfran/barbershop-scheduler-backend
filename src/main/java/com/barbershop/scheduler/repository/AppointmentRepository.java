package com.barbershop.scheduler.repository;

import com.barbershop.scheduler.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByEmployee_IdAndDateTime(Long employeeId, LocalDateTime dateTime);
}
