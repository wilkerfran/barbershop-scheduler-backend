package com.barbershop.scheduler.mapper;

import com.barbershop.scheduler.dto.BarberDTO;
import com.barbershop.scheduler.model.Barber;

public class BarberMapper {

    public static BarberDTO toDTO(Barber barber) {
        return BarberDTO.builder()
                .id(barber.getId())
                .name(barber.getName())
                .phone(barber.getPhone())
                .specialty(barber.getSpecialty())
                .build();
    }

    public static Barber toEntity(BarberDTO dto) {
        return Barber.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .specialty(dto.getSpecialty())
                .build();
    }
}
