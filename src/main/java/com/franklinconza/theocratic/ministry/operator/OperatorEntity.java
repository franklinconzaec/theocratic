package com.franklinconza.theocratic.ministry.operator;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "ministry", name = "operators")
public class OperatorEntity {
    @Id
    @Column(name = "operator_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false, unique = true)
    private String name;
}
