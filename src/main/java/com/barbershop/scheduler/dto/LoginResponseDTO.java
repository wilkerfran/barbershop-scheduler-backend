package com.barbershop.scheduler.dto;

public class LoginResponseDTO {
    private String name;
    private String email;
    private String role;

    public LoginResponseDTO(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
