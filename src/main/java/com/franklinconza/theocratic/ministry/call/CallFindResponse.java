package com.franklinconza.theocratic.ministry.call;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CallFindResponse {

    @Id
    private String id;
    private int conductorId;
    private String conductor;
    private String phone;
    private String owner;
    private Integer publisherId;
    private String publisher;
    private Integer stateId;
    private String state;
    private String observation;
}
