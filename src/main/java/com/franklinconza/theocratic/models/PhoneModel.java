package com.franklinconza.theocratic.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "ministry", name = "phones")
public class PhoneModel {
    @Id
    @Column(name = "phone_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false, unique = true)
    private String number;

    @Column(length = 50, nullable = false)
    private String owner;

    @Column(nullable = false)
    private String address;

    private Boolean occupied;

    @ManyToOne
    @JoinColumn(name = "operator_id", nullable = false)
    private OperatorModel operator;
}
