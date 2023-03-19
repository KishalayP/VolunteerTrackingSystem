package com.spring.volunteertracking.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "TEST")
public class UsersEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "UserID")
    private UsersPwdEntity usersPwdEntity;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ID")
    private UUID id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Location")
    private String location;
    @Column(name = "Date of Birth")
    private Date dateOfBirth;
    @Column(name = "Contact Number")
    private String contactNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(location, that.location) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(contactNumber, that.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, dateOfBirth, contactNumber);
    }
}
