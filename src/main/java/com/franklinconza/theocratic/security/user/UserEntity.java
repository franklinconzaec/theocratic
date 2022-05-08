package com.franklinconza.theocratic.security.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "security", name = "users")
public class UserEntity {
    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false, unique = true)
    private String dni;

    @Column(length = 50, nullable = false, unique = true)
    private String name;
}
