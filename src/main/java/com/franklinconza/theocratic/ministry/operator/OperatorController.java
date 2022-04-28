package com.franklinconza.theocratic.ministry.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/operator")
public class OperatorController {

    private OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @GetMapping
    public ArrayList<OperatorDto> findAll() {
        return operatorService.findAll();
    }

    @GetMapping("/id")
    public OperatorDto findById(@RequestParam Integer id) {
        return operatorService.findById(id);
    }

    @PostMapping
    public OperatorDto save(@RequestBody OperatorDto operatorDTO) {
        return operatorService.save(operatorDTO);
    }

    @PutMapping
    public OperatorDto update(@RequestBody OperatorDto operatorDTO) {
        return operatorService.update(operatorDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        operatorService.delete(id);
    }
}
