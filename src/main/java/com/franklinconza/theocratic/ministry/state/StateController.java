package com.franklinconza.theocratic.ministry.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/state")
public class StateController {

    private StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public ArrayList<StateDto> findAll() {
        return stateService.findAll();
    }

    @GetMapping("/id")
    public StateDto findById(@RequestParam Integer id) {
        return stateService.findById(id);
    }

    @PostMapping
    public StateDto save(@RequestBody StateDto stateDTO) {
        return stateService.save(stateDTO);
    }

    @PutMapping
    public StateDto update(@RequestParam StateDto stateDTO) {
        return stateService.update(stateDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        stateService.delete(id);
    }
}
