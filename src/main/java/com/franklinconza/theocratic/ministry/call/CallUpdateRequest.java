package com.franklinconza.theocratic.ministry.call;

import lombok.Data;

@Data
public class CallUpdateRequest {

    private String id;
    private int conductorId;
    private int publisherId;
    private int stateId;
    private String observation;
}
