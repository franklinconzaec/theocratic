package com.franklinconza.theocratic.ministry.operator;

import com.franklinconza.theocratic.models.OperatorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperatorService {

    private OperatorRepository operatorRepository;
    private OperatorMapper operatorMapper;

    @Autowired
    public OperatorService(OperatorRepository operatorRepository, OperatorMapper operatorMapper) {
        this.operatorRepository = operatorRepository;
        this.operatorMapper = operatorMapper;
    }

    public ArrayList<OperatorDto> findAll() {
        List<OperatorModel> operatorsModel = operatorRepository.findAll();
        ArrayList<OperatorDto> operatorsDto = (ArrayList<OperatorDto>) operatorsModel.stream().map(operatorMapper::convertToDto).collect(Collectors.toList());
        return operatorsDto;
    }

    public OperatorDto findById(Integer id) {
        OperatorModel operatorModel = operatorRepository.findById(id).get();
        OperatorDto operatorDTO = operatorMapper.convertToDto(operatorModel);
        return operatorDTO;
    }

    public OperatorDto save(OperatorDto operatorDTO) {
        OperatorModel operatorModel = operatorMapper.convertToModel(operatorDTO);
        operatorModel = operatorRepository.save(operatorModel);
        operatorDTO = operatorMapper.convertToDto(operatorModel);

        return operatorDTO;
    }

    public OperatorDto update(OperatorDto operatorDTO) {
        OperatorModel operatorModel = operatorMapper.convertToModel(operatorDTO);
        operatorModel = operatorRepository.save(operatorModel);
        operatorDTO = operatorMapper.convertToDto(operatorModel);

        return operatorDTO;
    }

    public void delete(Integer id) {
        operatorRepository.deleteById(id);
    }
}
