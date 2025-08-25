package com.barbershop.scheduler.mapper;

import com.barbershop.scheduler.dto.UserDTO;
import com.barbershop.scheduler.dto.UserRequestDTO;
import com.barbershop.scheduler.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setBirthDate(dto.getBirthDate());
        user.setCpf(dto.getCpf());
        user.setCep(dto.getCep());
        user.setStreet(dto.getStreet());
        user.setNumber(dto.getNumber());
        user.setComplement(dto.getComplement());
        user.setCity(dto.getCity());
        user.setDistrict(dto.getDistrict());
        user.setState(dto.getState());
        user.setPassword(dto.getPassword()); // cuidado: hash depois no service
        return user;
    }

    public static UserDTO toDTO(User user) {
        if (user == null) return null;

        return new UserDTO(
            user.getName(),
            user.getEmail(),
            user.getPhone(),
            user.getBirthDate(),
            user.getCpf(),
            user.getCep(),
            user.getStreet(),
            user.getNumber(),
            user.getComplement(),
            user.getCity(),
            user.getDistrict(),
            user.getState(),
            user.getProfilePicture(),
            user.getRole()
        );
    }
}
