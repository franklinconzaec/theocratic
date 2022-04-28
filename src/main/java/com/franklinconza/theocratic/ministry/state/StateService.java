package com.franklinconza.theocratic.ministry.state;

import com.franklinconza.theocratic.models.StateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    private StateRepository stateRepository;
    private StateMapper stateMapper;

    @Autowired
    public StateService(StateRepository stateRepository, StateMapper stateMapper) {
        this.stateRepository = stateRepository;
        this.stateMapper = stateMapper;
    }

    public ArrayList<StateDto> findAll() {
        List<StateModel> statesModel = stateRepository.findAll();
        ArrayList<StateDto> statesDto = (ArrayList<StateDto>) statesModel.stream().map(stateMapper::convertToDto).collect(Collectors.toList());
        return statesDto;

    }

    public StateDto findById(Integer id) {
        StateModel stateModel = stateRepository.findById(id).get();
        StateDto stateDTO = stateMapper.convertToDto(stateModel);

        return stateDTO;
    }

    public StateDto save(StateDto stateDTO) {
        StateModel stateModel = stateMapper.convertToModel(stateDTO);
        stateModel = stateRepository.save(stateModel);
        stateDTO = stateMapper.convertToDto(stateModel);

        return stateDTO;
    }

    public StateDto update(StateDto stateDTO) {
        StateModel stateModel = stateMapper.convertToModel(stateDTO);
        stateModel = stateRepository.save(stateModel);
        stateDTO = stateMapper.convertToDto(stateModel);

        return stateDTO;
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
