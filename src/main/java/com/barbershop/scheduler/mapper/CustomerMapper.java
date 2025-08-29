package com.barbershop.scheduler.mapper;

import com.barbershop.scheduler.dto.CustomerDTO;
import com.barbershop.scheduler.model.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .build();
    }

    public static Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .build();
    }
}
