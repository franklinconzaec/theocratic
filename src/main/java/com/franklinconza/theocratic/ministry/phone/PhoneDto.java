package com.franklinconza.theocratic.ministry.phone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto {
    private Integer id;
    private String number;
    private String owner;
    private String address;
    private Boolean occupied;
}
