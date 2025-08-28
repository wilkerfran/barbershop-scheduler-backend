package com.barbershop.scheduler.repository;

import com.barbershop.scheduler.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
