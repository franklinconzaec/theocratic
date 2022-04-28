package com.franklinconza.theocratic.ministry.phone;

import com.franklinconza.theocratic.ministry.phone.PhoneDto;
import com.franklinconza.theocratic.models.PhoneModel;
import com.franklinconza.theocratic.models.PhoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;
    private PhoneMapper phoneMapper;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }

    public ArrayList<PhoneDto> findAll() {
        List<PhoneModel> phonesModel = phoneRepository.findAll();
        ArrayList<PhoneDto> phonesDto = (ArrayList<PhoneDto>) phonesModel.stream().map(phoneMapper::convertToDto).collect(Collectors.toList());
        return phonesDto;

    }

    public PhoneDto findById(Integer id) {
        PhoneModel phoneModel = phoneRepository.findById(id).get();
        PhoneDto phoneDTO = phoneMapper.convertToDto(phoneModel);
        return phoneDTO;
    }

    public PhoneDto save(PhoneDto phoneDTO) {
        PhoneModel phoneModel = phoneMapper.convertToModel(phoneDTO);
        phoneModel = phoneRepository.save(phoneModel);
        phoneDTO = phoneMapper.convertToDto(phoneModel);

        return phoneDTO;
    }

    public PhoneDto update(PhoneDto phoneDTO) {
        PhoneModel phoneModel = phoneMapper.convertToModel(phoneDTO);
        phoneModel = phoneRepository.save(phoneModel);
        phoneDTO = phoneMapper.convertToDto(phoneModel);

        return phoneDTO;
    }

    public void delete(Integer id) {
        phoneRepository.deleteById(id);
    }
}
