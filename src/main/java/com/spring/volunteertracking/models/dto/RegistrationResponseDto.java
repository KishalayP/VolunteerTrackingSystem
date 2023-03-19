package com.spring.volunteertracking.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class RegistrationResponseDto {

    private UUID userId;
    private String message;
    private String email;
    private String name;


}
