package com.barbershop.scheduler.controller;

import com.barbershop.scheduler.dto.UserDTO;
import com.barbershop.scheduler.dto.UserRequestDTO;
import com.barbershop.scheduler.dto.LoginRequestDTO;
import com.barbershop.scheduler.dto.LoginResponseDTO;
import com.barbershop.scheduler.model.User;
import com.barbershop.scheduler.service.UserService;
import com.barbershop.scheduler.mapper.UserMapper;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // Criação de usuário
    @PostMapping
    public UserDTO createUser(@RequestBody UserRequestDTO dto) {
        // Criptografa a senha antes de salvar
        User user = UserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userService.saveUser(user);
        return UserMapper.toDTO(savedUser);
    }

    // Login
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
        User user = userService.getUserByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        return new LoginResponseDTO(user.getName(), user.getEmail(), user.getRole());
    }

    // Listagem de usuários
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    // Buscar usuário por email
    @GetMapping("/{email}")
    public Optional<UserDTO> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(UserMapper::toDTO);
    }
}
