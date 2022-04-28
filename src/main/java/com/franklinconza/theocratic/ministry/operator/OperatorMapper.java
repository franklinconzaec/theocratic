package com.franklinconza.theocratic.ministry.operator;

import com.franklinconza.theocratic.models.OperatorModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorMapper {

    private ModelMapper modelMapper;

    @Autowired
    public OperatorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OperatorDto convertToDto(OperatorModel operatorModel) {
        OperatorDto operatorDTO = modelMapper.map(operatorModel, OperatorDto.class);
        return operatorDTO;
    }

    public OperatorModel convertToModel(OperatorDto operatorDTO) {
        OperatorModel operatorModel = modelMapper.map(operatorDTO, OperatorModel.class);
        return operatorModel;
    }
}
