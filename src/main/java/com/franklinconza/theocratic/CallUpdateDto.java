package com.franklinconza.theocratic;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CallUpdateDto {

    private UUID id;
    private int conductorId;
    private int publisherId;
    private int stateId;
    private String observation;
}
