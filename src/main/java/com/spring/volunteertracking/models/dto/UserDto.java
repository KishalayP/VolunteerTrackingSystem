package com.spring.volunteertracking.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private UUID id;

    private String name;

    private String location;

    private Date dateOfBirth;

    private String contactNumber;

    private String password;

}
