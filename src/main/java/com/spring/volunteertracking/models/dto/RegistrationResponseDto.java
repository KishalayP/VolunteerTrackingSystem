package com.spring.volunteertracking.models.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class RegistrationResponseDto extends RepresentationModel<RegistrationResponseDto> {

    private UUID userId;
    private String message;
    private String email;
    private String name;
}
