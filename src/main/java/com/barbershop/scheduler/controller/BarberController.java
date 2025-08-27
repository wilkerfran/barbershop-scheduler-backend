package com.barbershop.scheduler.controller;

import com.barbershop.scheduler.dto.BarberDTO;
import com.barbershop.scheduler.mapper.BarberMapper;
import com.barbershop.scheduler.model.Barber;
import com.barbershop.scheduler.service.BarberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/barbers")
public class BarberController {

    private final BarberService barberService;

    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @PostMapping
    public BarberDTO createBarber(@RequestBody BarberDTO dto) {
        Barber savedBarber = barberService.saveBarber(BarberMapper.toEntity(dto));
        return BarberMapper.toDTO(savedBarber);
    }

    @GetMapping
    public List<BarberDTO> getAllBarbers() {
        return barberService.getAllBarbers()
                .stream()
                .map(BarberMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BarberDTO getBarberById(@PathVariable Long id) {
        return barberService.getBarberById(id)
                .map(BarberMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Barber not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteBarber(@PathVariable Long id) {
        barberService.deleteBarber(id);
    }
}
