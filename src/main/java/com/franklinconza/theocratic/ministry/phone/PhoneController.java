package com.franklinconza.theocratic.ministry.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    private PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public ArrayList<PhoneDto> findAll() {
        return phoneService.findAll();
    }

    @GetMapping("/id")
    public PhoneDto findById(@RequestParam Integer id) {
        return phoneService.findById(id);
    }

    @PostMapping
    public PhoneDto save(@RequestBody PhoneDto phoneDTO) {
        return phoneService.save(phoneDTO);
    }

    @PutMapping
    public PhoneDto update(@RequestBody PhoneDto phoneDTO) {
        return phoneService.update(phoneDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        phoneService.delete(id);
    }
}
