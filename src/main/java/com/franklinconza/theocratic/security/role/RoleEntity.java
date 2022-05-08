package com.franklinconza.theocratic.security.role;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "security", name = "roles")
public class RoleEntity {
    @Id
    @Column(name = "role_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;
}
