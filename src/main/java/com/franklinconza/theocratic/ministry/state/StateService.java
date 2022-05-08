package com.franklinconza.theocratic.ministry.state;

import com.franklinconza.theocratic.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;
    private final Mapper mapper;

    public List<StateFindResponse> findAll() {
        List<StateEntity> statesModel = stateRepository.findAll();
        return mapper.mapList(statesModel, StateFindResponse.class);
    }

    public StateFindResponse findById(int id) {
        StateEntity stateEntity = stateRepository.findById(id).get();
        return mapper.map(stateEntity, StateFindResponse.class);
    }
}
