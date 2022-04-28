package com.franklinconza.theocratic.security.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "security", name = "permissions")
public class PermissionModel {
    @Id
    @Column(name = "permission_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleModel role;
}
