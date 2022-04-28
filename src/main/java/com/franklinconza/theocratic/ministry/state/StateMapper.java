package com.franklinconza.theocratic.ministry.state;

import com.franklinconza.theocratic.models.StateModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {

    private ModelMapper modelMapper;

    @Autowired
    public StateMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StateDto convertToDto(StateModel stateModel) {
        StateDto stateDTO = modelMapper.map(stateModel, StateDto.class);
        return stateDTO;
    }

    public StateModel convertToModel(StateDto stateDTO) {
        StateModel stateModel = modelMapper.map(stateDTO, StateModel.class);
        return stateModel;
    }
}
