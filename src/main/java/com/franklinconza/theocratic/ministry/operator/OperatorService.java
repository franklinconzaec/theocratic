package com.franklinconza.theocratic.ministry.operator;

import com.franklinconza.theocratic.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatorService {

    private final OperatorRepository operatorRepository;
    private final Mapper mapper;

    public List<OperatorDto> findAll() {
        List<OperatorEntity> operatorsModel = operatorRepository.findAll();
        return mapper.mapList(operatorsModel, OperatorDto.class);
    }

    public OperatorDto findById(Integer id) {
        OperatorEntity operatorEntity = operatorRepository.findById(id).get();
        return mapper.map(operatorEntity, OperatorDto.class);
    }

    public OperatorDto save(OperatorDto operatorDTO) {
        OperatorEntity operatorEntity = mapper.map(operatorDTO, OperatorEntity.class);
        operatorRepository.save(operatorEntity);
        return mapper.map(operatorEntity, OperatorDto.class);
    }

    public OperatorDto update(OperatorDto operatorDTO) {
        OperatorEntity operatorEntity = mapper.map(operatorDTO, OperatorEntity.class);
        operatorRepository.save(operatorEntity);
        return mapper.map(operatorEntity, OperatorDto.class);
    }

    public void delete(Integer id) {
        operatorRepository.deleteById(id);
    }
}
