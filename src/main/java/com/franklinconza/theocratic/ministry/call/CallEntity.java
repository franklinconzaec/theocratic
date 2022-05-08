package com.franklinconza.theocratic.ministry.call;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(schema = "ministry", name = "calls")
public class CallEntity {
    @Id
    @Column(name = "call_id", nullable = false, unique = true)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(nullable = false)
    private Date date;

    @Column(name = "phone_id", nullable = false)
    private Integer phone;

    @Column(name = "conductor_id", nullable = false)
    private Integer conductor;

    @Column(length = 10, nullable = false)
    private String section;

    @Column(name = "state_id", nullable = false)
    private Integer state;

    @Column(name = "publisher_id", nullable = false)
    private Integer publisher;

    private String observation;
}
