package com.barbershop.scheduler.repository;

import com.barbershop.scheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // já tem métodos prontos: save, findAll, findById, delete...
    
    // você pode adicionar consultas customizadas
    Optional<User> findByEmail(String email);
}
