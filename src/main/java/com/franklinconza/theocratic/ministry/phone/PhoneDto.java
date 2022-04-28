package com.franklinconza.theocratic.ministry.phone;

import lombok.Data;

@Data
public class PhoneDto {
    private Integer id;
    private String number;
    private String owner;
    private String address;
    private Boolean occupied;
}
