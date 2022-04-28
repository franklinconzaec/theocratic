package com.franklinconza.theocratic.ministry.call;

import com.franklinconza.theocratic.models.CallModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CallMapper {

    private ModelMapper modelMapper;

    public CallMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CallDto convertToDto(CallModel callModel) {
        CallDto callDTO = modelMapper.map(callModel, CallDto.class);
        return callDTO;
    }

    public CallModel convertToModel(CallDto callDTO) {
        CallModel callModel = modelMapper.map(callDTO, CallModel.class);
        return callModel;
    }
}
