package com.franklinconza.theocratic.ministry.call;

import com.franklinconza.theocratic.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CallService {

    private final CallRepository callRepository;
    private final CallFindResponseRepository callFindResponseRepository;
    private final Mapper mapper;

    public List<CallDto> findAll() {
        List<CallEntity> callsModel = callRepository.findAll();
        return mapper.mapList(callsModel, CallDto.class);
    }

    public CallDto findById(UUID id) {
        CallEntity callEntity = callRepository.findById(id).get();
        return mapper.map(callEntity, CallDto.class);
    }

    public List<CallFindResponse> findCallByDateAndSection(Date date, String section) {
        return callFindResponseRepository.findCallByDateAndSection(date, section);
    }

    public CallDto save(CallDto callDTO) {
        CallEntity callEntity = mapper.map(callDTO, CallEntity.class);
        callRepository.save(callEntity);
        return mapper.map(callEntity, CallDto.class);
    }

    public CallFindResponse update(CallUpdateRequest callUpdateRequest) {
        Optional<CallEntity> callEntity = callRepository.findById(UUID.fromString(callUpdateRequest.getId()));
        callEntity.get().setConductor(callUpdateRequest.getConductorId());
        callEntity.get().setPublisher(callUpdateRequest.getPublisherId());
        callEntity.get().setState(callUpdateRequest.getStateId());
        callEntity.get().setObservation(callUpdateRequest.getObservation());

        callRepository.save(callEntity.get());

        return mapper.map(callEntity, CallFindResponse.class);
    }

    public void delete(UUID id) {
        callRepository.deleteById(id);
    }
}
