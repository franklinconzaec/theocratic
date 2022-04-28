package com.franklinconza.theocratic.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "ministry", name = "states")
public class StateModel {
    @Id
    @Column(name = "state_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 25, nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String description;
}
