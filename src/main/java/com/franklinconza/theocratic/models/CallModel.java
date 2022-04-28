package com.franklinconza.theocratic.models;

import com.franklinconza.theocratic.security.models.UserModel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(schema = "ministry", name = "calls")
public class CallModel {
    @Id
    @Column(name = "call_id", nullable = false, unique = true)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "phone_id", nullable = false)
    private PhoneModel phone;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private UserModel conductor;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private SectionModel section;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private StateModel state;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private UserModel publisher;

    private String observation;
}
