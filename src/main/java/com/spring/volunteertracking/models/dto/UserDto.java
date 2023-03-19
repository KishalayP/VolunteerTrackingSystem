package com.spring.volunteertracking.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
public class UserDto {

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Location cannot be null")
    private String location;

    @NotNull(message = "Date Of Birth cannot be null")
    private Date dateOfBirth;

    @Size(min = 10, max = 10, message
            = "Contact Number must be 10 digits")
    private String contactNumber;

    @NotNull(message = "Password cannot be null")
    private String password;

}
