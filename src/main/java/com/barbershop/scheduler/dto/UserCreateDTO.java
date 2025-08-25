package com.barbershop.scheduler.dto;

public class UserCreateDTO {
    private String name;
    private String email;
    private String role; // CLIENTE, FUNCIONARIO, ADMIN

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
