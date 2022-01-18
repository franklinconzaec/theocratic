package com.franklinconza.theocratic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatorDTO {
    private Integer id;
    private String name;
    //private List<Phone> phones;
}
