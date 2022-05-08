package com.franklinconza.theocratic.ministry.call;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallDto {
    private String id;
    private String number;
    private String owner;
    private String address;
    private Boolean occupied;
}
