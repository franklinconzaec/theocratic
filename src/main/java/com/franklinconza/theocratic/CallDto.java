package com.franklinconza.theocratic;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CallDto {

    private UUID id;
    private Date date;
    private String section;
    private int conductorId;
    private String conductor;
    private String phone;
    private String owner;
    private int publisherId;
    private String publisher;
    private int stateId;
    private String state;
    private String observation;
}
