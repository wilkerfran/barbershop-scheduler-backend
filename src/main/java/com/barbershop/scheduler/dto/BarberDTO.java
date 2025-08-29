package com.barbershop.scheduler.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarberDTO {
    private Long id;
    private String name;
    private String phone;
    private String specialty;
}
