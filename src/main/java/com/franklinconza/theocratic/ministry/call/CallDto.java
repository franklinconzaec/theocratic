package com.franklinconza.theocratic.ministry.call;

import lombok.Data;

import java.util.UUID;

@Data
public class CallDto {
    private UUID id;
    private String number;
    private String owner;
    private String address;
    private Boolean occupied;
}
