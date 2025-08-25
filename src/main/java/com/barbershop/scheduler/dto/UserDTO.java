package com.barbershop.scheduler.dto;

import java.time.LocalDate;

public class UserDTO {

    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String cpf;
    private String cep;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String district;
    private String state;
    private String profilePicture;
    private String role;

    public UserDTO(String name, String email, String phone, LocalDate birthDate, String cpf,
                   String cep, String street, String number, String complement,
                   String city, String district, String state, String profilePicture,
                   String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.cpf = cpf;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.district = district;
        this.state = state;
        this.profilePicture = profilePicture;
        this.role = role;
    }

    // Getters e Setters
    // (adicione todos se precisar de serialização/deserialização)
}
