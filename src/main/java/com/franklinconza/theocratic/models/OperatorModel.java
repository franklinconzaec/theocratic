package com.franklinconza.theocratic.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "ministry", name = "operators")
public class OperatorModel {
    @Id
    @Column(name = "operator_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;
}
