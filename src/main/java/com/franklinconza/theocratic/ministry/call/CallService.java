package com.franklinconza.theocratic.ministry.call;

import com.franklinconza.theocratic.models.CallModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CallService {

    private CallRepository callRepository;
    private CallMapper callMapper;

    @Autowired
    public CallService(CallRepository callRepository, CallMapper callMapper) {
        this.callRepository = callRepository;
        this.callMapper = callMapper;
    }

    public ArrayList<CallDto> findAll() {
        List<CallModel> callsModel = callRepository.findAll();
        ArrayList<CallDto> callsDto = (ArrayList<CallDto>) callsModel.stream().map(callMapper::convertToDto).collect(Collectors.toList());
        return callsDto;
    }

    public CallDto findById(UUID id) {
        CallModel callModel = callRepository.findById(id).get();
        CallDto callDTO = callMapper.convertToDto(callModel);
        return callDTO;
    }

    public CallDto save(CallDto callDTO) {
        CallModel callModel = callMapper.convertToModel(callDTO);
        callModel = callRepository.save(callModel);
        callDTO = callMapper.convertToDto(callModel);

        return callDTO;
    }

    public CallDto update(CallDto callDTO) {
        CallModel callModel = callMapper.convertToModel(callDTO);
        callModel = callRepository.save(callModel);
        callDTO = callMapper.convertToDto(callModel);

        return callDTO;
    }

    public void delete(UUID id) {
        callRepository.deleteById(id);
    }
}
