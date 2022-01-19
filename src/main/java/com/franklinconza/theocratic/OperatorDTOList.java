package com.franklinconza.theocratic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatorDTOList {
    private ArrayList<OperatorDTO> operators;

    public OperatorDTOList(){
        operators = new ArrayList<>();
    }
}
