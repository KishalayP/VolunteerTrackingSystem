package com.spring.volunteertracking.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must contain:" +
            " At least 8 chars\n" +
            "\n" +
            "Contains at least one digit\n" +
            "\n" +
            "Contains at least one lower alpha char and one upper alpha char\n" +
            "\n" +
            "Contains at least one char within a set of special chars (@#%$^ etc.)\n" +
            "\n" +
            "Does not contain space, tab, etc.")
    private String password;

}
