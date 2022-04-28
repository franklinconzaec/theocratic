package com.franklinconza.theocratic.ministry.phone;

import com.franklinconza.theocratic.models.PhoneModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {

    private ModelMapper modelMapper;

    @Autowired
    public PhoneMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PhoneDto convertToDto(PhoneModel phoneModel) {
        PhoneDto phoneDTO = modelMapper.map(phoneModel, PhoneDto.class);
        return phoneDTO;
    }

    public PhoneModel convertToModel(PhoneDto phoneDTO) {
        PhoneModel phoneModel = modelMapper.map(phoneDTO, PhoneModel.class);
        return phoneModel;
    }
}
