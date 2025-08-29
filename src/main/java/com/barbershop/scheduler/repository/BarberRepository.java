package com.barbershop.scheduler.repository;

import com.barbershop.scheduler.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
}
