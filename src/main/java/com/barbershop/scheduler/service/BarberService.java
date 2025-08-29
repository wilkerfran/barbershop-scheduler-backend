package com.barbershop.scheduler.service;

import com.barbershop.scheduler.model.Barber;
import com.barbershop.scheduler.repository.BarberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberService {

    private final BarberRepository barberRepository;

    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public Barber saveBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(id);
    }

    public void deleteBarber(Long id) {
        barberRepository.deleteById(id);
    }
}
