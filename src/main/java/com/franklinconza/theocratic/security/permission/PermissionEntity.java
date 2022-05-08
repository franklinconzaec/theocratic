package com.franklinconza.theocratic.security.permission;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "security", name = "permissions")
public class PermissionEntity {
    @Id
    @Column(name = "permission_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private String user;

    @Column(name = "role_id", nullable = false)
    private String role;
}
