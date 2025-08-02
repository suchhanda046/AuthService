package com.example.Auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "auth_user")
public class User {
    @Id
    private int Id;
    private String username;
    private String password;
    private String email;
    private List<String> roles;
    private Date createDate;

}
