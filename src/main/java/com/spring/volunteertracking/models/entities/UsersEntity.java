package com.spring.volunteertracking.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "TEST")
public class UsersEntity {
    @Id
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "USERID", nullable = false)
    private UsersPwdEntity usersPwdById;

}
