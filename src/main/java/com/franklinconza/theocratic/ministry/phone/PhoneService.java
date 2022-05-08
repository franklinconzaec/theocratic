package com.franklinconza.theocratic.ministry.phone;

import com.franklinconza.theocratic.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final Mapper mapper;

    public List<PhoneDto> findAll() {
        List<PhoneEntity> phonesModel = phoneRepository.findAll();
        return mapper.mapList(phonesModel, PhoneDto.class);
    }

    public PhoneDto findById(Integer id) {
        PhoneEntity phoneEntity = phoneRepository.findById(id).get();
        return mapper.map(phoneEntity, PhoneDto.class);
    }

    public PhoneDto save(PhoneDto phoneDTO) {
        PhoneEntity phoneEntity = mapper.map(phoneDTO, PhoneEntity.class);
        phoneRepository.save(phoneEntity);
        return mapper.map(phoneEntity, PhoneDto.class);
    }

    public PhoneDto update(PhoneDto phoneDTO) {
        PhoneEntity phoneEntity = mapper.map(phoneDTO, PhoneEntity.class);
        phoneRepository.save(phoneEntity);
        return mapper.map(phoneEntity, PhoneDto.class);
    }

    public void delete(Integer id) {
        phoneRepository.deleteById(id);
    }
}
