package com.franklinconza.theocratic.ministry.call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/call")
public class CallController {

    private CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping
    public ArrayList<CallDto> findAll() {
        return callService.findAll();
    }

    @GetMapping("/id")
    public CallDto findById(@RequestParam UUID id) {
        return callService.findById(id);
    }

    @PostMapping
    public CallDto save(@RequestBody CallDto callDTO) {
        return callService.save(callDTO);
    }

    @PutMapping
    public CallDto update(@RequestBody CallDto callDTO) {
        return callService.update(callDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam UUID id) {
        callService.delete(id);
    }
}
